package number_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.imageio.stream.FileCacheImageOutputStream;

public class CopyFileTaskThread implements Task, Runnable{
	
	private final Thread thread;
	private final Path file;
	private final Path copeFile;
	private final long fileSize;
	private volatile long copied;
	
	

	public CopyFileTaskThread(Path file, Path copeFile) throws IOException {
		super();
		this.thread = new Thread (this, "CopyFileTaskThread");
		this.file = file;
		this.copeFile = copeFile;
		this.fileSize = Files.size(file);
		this.copied = 0;
		
	}

	@Override
	public void run() {
		byte[] buffer = new byte [8192];
		try(InputStream in = new FileInputStream(file.toFile());
				OutputStream out = new FileOutputStream(copeFile.toFile())){
			int read = in.read(buffer);
			while(!Thread.interrupted()){
				if(read == -1){
					break;
				}
				out.write(buffer, 0, read);
				copied += read;
			}
			out.flush();
			
		}catch (Exception e) {
			System.err.println("Copy failed: "+e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	public void start() {
		if(thread.getState() != Thread.State.NEW){
			throw new IllegalArgumentException("CopyFileTask already executed");
		}
		this.thread.start();
	}

	@Override
	public void interrupt() {
		this.thread.interrupt();
		
	}

	@Override
	public int getPercentProgress() {
		return (int)(copied * 100 / fileSize);
	}

	
}
