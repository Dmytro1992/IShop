package gomoky;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gomoky.impl.DefaultComputerTurn;
import gomoky.impl.DefaultConstants;
import gomoky.impl.DefaultGameTable;
import gomoky.impl.DefaultHumanTurn;
import gomoky.impl.DefaultWinnerChecker;


public class GUIGomoku extends JFrame {
	private static final Logger LOGGER = LoggerFactory.getLogger(GUIGomoku.class);
	private static final long serialVersionUID = 1714372457079337160L;
	private JLabel cells[][] = new JLabel[DefaultConstants.SIZE][DefaultConstants.SIZE];
	private final ComputerTurn computerTurn;
	private final WinnerChecker winnerChecker;
	private final HumanTurn humanTurn;
	private final GameTable gameTable;

	public GUIGomoku() throws HeadlessException {
		super("Gomoku");
		createGameUITable();
		computerTurn = new DefaultComputerTurn();
		winnerChecker = new DefaultWinnerChecker();
		humanTurn = new DefaultHumanTurn();
		gameTable = new DefaultGameTable();
	}

	public void createGameUITable() {
		setLayout(new GridLayout(DefaultConstants.SIZE, DefaultConstants.SIZE));
		for (int i = 0; i < DefaultConstants.SIZE; i++) {
			for (int j = 0; j < DefaultConstants.SIZE; j++) {
				final int row = i;
				final int col = j;
				JLabel p = new JLabel();
				cells[i][j] = p;
				p.setPreferredSize(new Dimension(45, 45));
				p.setHorizontalAlignment(SwingConstants.CENTER);
				p.setVerticalAlignment(SwingConstants.CENTER);
				p.setFont(new Font(Font.SERIF, Font.PLAIN, 35));
				p.setForeground(Color.BLUE);
				p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				add(p);
				p.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						handleHumanTurn(row, col);
					}
				});
			}
		}

		DefaultGameTable.init();
	}

	public void startNewGame() {
		DefaultGameTable.init();
		for (int i = 0; i < DefaultConstants.SIZE; i++) {
			for (int j = 0; j < DefaultConstants.SIZE; j++) {
				cells[i][j].setText(String.valueOf(DefaultGameTable.gameTable[i][j]));
				cells[i][j].setFont(new Font(Font.SERIF, Font.PLAIN, 35));
				cells[i][j].setForeground(Color.BLACK);
			}
		}
		LOGGER.info("New game started with game table {}x{}",DefaultConstants.SIZE,DefaultConstants.SIZE );
			
	}

	public void stopGame() {
		for (int i = 0; i < DefaultConstants.SIZE; i++) {
			for (int j = 0; j < DefaultConstants.SIZE; j++) {
				cells[i][j].removeMouseListener(cells[i][j].getMouseListeners()[0]);
			}
		}
		LOGGER.info("Game disabled with game table {}x{}",DefaultConstants.SIZE,DefaultConstants.SIZE );
	}

	public void handleHumanTurn(int row, int col) {
		if (gameTable.isCellFree(row, col)) {
			humanTurn.makeHumanTurn(row, col, cells);
			char ch = winnerChecker.findWinner(cells);
			if (ch == CellValue.HUMAN.getCell()) {
				LOGGER.info("Human wins: {}", CellValue.HUMAN);
				if (JOptionPane.showConfirmDialog(this, "Game over: User win!\nNew game?") == JOptionPane.YES_OPTION) {
					startNewGame();
				} else {
					stopGame();
				}
			} else if (ch == CellValue.COMPUTER.getCell()) {
				LOGGER.info("Human wins: {}", CellValue.COMPUTER);
				if (JOptionPane.showConfirmDialog(this, "Game over: Computer wins!\nNew game?") == JOptionPane.YES_OPTION) {
					startNewGame();
				} else {
					stopGame();
				}
			}
			computerTurn.makeComputerTurn(cells);
			ch = winnerChecker.findWinner(cells);
			if (ch == CellValue.HUMAN.getCell()) {
				if (JOptionPane.showConfirmDialog(this, "Game over: User win!\nNew game?") == JOptionPane.YES_OPTION) {
					startNewGame();
				} else {
					stopGame();
				}
			} else if (ch == CellValue.COMPUTER.getCell()) {
				LOGGER.info("Computer wins: {}", CellValue.COMPUTER);
				if (JOptionPane.showConfirmDialog(this, "Game over: Computer wins!\nNew game?") == JOptionPane.YES_OPTION) {
					startNewGame();
				} else {
					stopGame();
				}
			}
		} else {
			LOGGER.warn("Cell {}:{} is not empty", row, col);
			JOptionPane.showMessageDialog(this, "Cell is not free! Click on free cell!");
		}
	}
	
	public static void main(String[] args) {
		GUIGomoku w = new GUIGomoku();
		w.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		w.setResizable(false);
		w.pack();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		w.setLocation(dim.width / 2 - w.getSize().width / 2, dim.height / 2 - w.getSize().height / 2);
		w.setVisible(true);
		LOGGER.info("New game started with game table {}x{}", DefaultConstants.SIZE, DefaultConstants.SIZE);
	}

}
