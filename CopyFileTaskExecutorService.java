package number_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyFileTaskExecutorService implements Task, Runnable{
	private final Path file;
	private final Path copyFile;
	private final long sizeFule;
	private  long copied;
	private final ExecutorService excutorService;

	
	
	public CopyFileTaskExecutorService(Path file, Path copyFile) throws IOException{
		super();
		this.file = file;
		this.copyFile = copyFile;
		this.sizeFule = Files.size(file);
		this.copied = 0;
		this.excutorService = Executors.newSingleThreadExecutor();
	}

	@Override
	public void run() {
		byte[] buffered = new byte[8192];
		try(InputStream in = new FileInputStream(file.toFile());
				OutputStream out = new FileOutputStream(copyFile.toFile())){
			while(!Thread.interrupted()){
				int read = in.read(buffered);
				if(read == -1){
					break;
				}
				out.write(buffered, 0, read);
				copied += read;
			}
			out.flush();
		}catch (IOException e) {
			System.err.println("Copy failed: " + e.getMessage());
			e.printStackTrace();
		}
		this.excutorService.shutdown();
		
	}

	@Override
	public void start() {
		if(excutorService.isShutdown()){
			throw new IllegalArgumentException("CopyFileTaskExecutorService already executed");
		}
		excutorService.submit(this);
	}

	@Override
	public void interrupt() {
		this.excutorService.shutdownNow();
		
	}

	@Override
	public int getPercentProgress() {
		return (int)(copied *100/sizeFule);
	}
	

}
