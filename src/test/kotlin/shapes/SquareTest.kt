package shapes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class SquareTest {

    @Test
    fun `square can be created when width and height are equal`() {
        val square = Square(Point(0.0, 0.0), Point(4.0, 4.0))

        assertEquals(4.0, square.getWidth())
        assertEquals(4.0, square.getHeight())
        assertEquals(16.0, square.getArea())
    }

    @Test
    fun `square cannot have unequal width and height`() {
        assertThrows(IllegalArgumentException::class.java) {
            Square(Point(0.0, 0.0), Point(5.0, 4.0))
        }
    }

    @Test
    fun `square can be moved`() {
        val square = Square(Point(0.0, 0.0), Point(4.0, 4.0))

        square.move(1.0, 2.0)

        assertEquals(1.0, square.getCorner1().getX())
        assertEquals(2.0, square.getCorner1().getY())
        assertEquals(5.0, square.getCorner2().getX())
        assertEquals(6.0, square.getCorner2().getY())
    }
}