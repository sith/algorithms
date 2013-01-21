package org.sith.algorithms.common.sudoku;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Date: 11/24/12
 * Time: 12:00 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class BoardTest {


    @Test
    public void testFillCell() throws Exception {

        SimpleBoard board = new SimpleBoard();


        SimpleBoard.Point point = new SimpleBoard.Point(1, 1);
        board.fillSquare(point, 3);

        int freeCount = board.getFreeCount();
        assertThat(freeCount, is(Board.NCELLS - 1));

        SimpleBoard.Candidates[][] boardCandidates = board.boardCandidates;
        for (int i = 1; i < boardCandidates.length; i++) {
            assertFalse(boardCandidates[1][i].candidates.contains(3));
            assertFalse(boardCandidates[i][1].candidates.contains(3));
        }
        assertFalse(boardCandidates[1][1].candidates.contains(3));
        assertFalse(boardCandidates[1][2].candidates.contains(3));
        assertFalse(boardCandidates[1][3].candidates.contains(3));

        assertFalse(boardCandidates[2][1].candidates.contains(3));
        assertFalse(boardCandidates[2][2].candidates.contains(3));
        assertFalse(boardCandidates[2][3].candidates.contains(3));

        assertFalse(boardCandidates[3][1].candidates.contains(3));
        assertFalse(boardCandidates[3][2].candidates.contains(3));
        assertFalse(boardCandidates[3][3].candidates.contains(3));


        board.freeSquare(point);


        for (int i = 1; i < boardCandidates.length; i++) {
            assertTrue(boardCandidates[1][i].candidates.contains(3));
            assertTrue(boardCandidates[i][1].candidates.contains(3));
        }
        assertTrue(boardCandidates[1][1].candidates.contains(3));
        assertTrue(boardCandidates[1][2].candidates.contains(3));
        assertTrue(boardCandidates[1][3].candidates.contains(3));

        assertTrue(boardCandidates[2][1].candidates.contains(3));
        assertTrue(boardCandidates[2][2].candidates.contains(3));
        assertTrue(boardCandidates[2][3].candidates.contains(3));

        assertTrue(boardCandidates[3][1].candidates.contains(3));
        assertTrue(boardCandidates[3][2].candidates.contains(3));
        assertTrue(boardCandidates[3][3].candidates.contains(3));









    }
}
