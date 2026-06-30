package shapes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class LineTest {

    @Test
    fun `line stores copies of start and end points`() {
        val start = Point(0.0, 0.0)
        val end = Point(3.0, 4.0)
        val line = Line(start, end)

        val returnedStart = line.getStart()
        val returnedEnd = line.getEnd()

        assertNotSame(start, returnedStart)
        assertNotSame(end, returnedEnd)
        assertEquals(0.0, returnedStart.getX())
        assertEquals(0.0, returnedStart.getY())
        assertEquals(3.0, returnedEnd.getX())
        assertEquals(4.0, returnedEnd.getY())
    }

    @Test
    fun `line cannot have zero length`() {
        assertThrows(IllegalArgumentException::class.java) {
            Line(Point(1.0, 1.0), Point(1.0, 1.0))
        }
    }

    @Test
    fun `line calculates length`() {
        val line = Line(Point(0.0, 0.0), Point(3.0, 4.0))

        assertEquals(5.0, line.getLength())
    }

    @Test
    fun `line calculates slope`() {
        val line = Line(Point(0.0, 0.0), Point(4.0, 2.0))

        assertEquals(0.5, line.getSlope())
    }

    @Test
    fun `vertical line throws exception for undefined slope`() {
        val line = Line(Point(2.0, 0.0), Point(2.0, 5.0))

        assertThrows(ArithmeticException::class.java) {
            line.getSlope()
        }
    }

    @Test
    fun `line can be moved`() {
        val line = Line(Point(0.0, 0.0), Point(3.0, 4.0))

        line.move(2.0, -1.0)

        assertEquals(2.0, line.getStart().getX())
        assertEquals(-1.0, line.getStart().getY())
        assertEquals(5.0, line.getEnd().getX())
        assertEquals(3.0, line.getEnd().getY())
    }

    @Test
    fun `returned points do not modify internal line points`() {
        val line = Line(Point(0.0, 0.0), Point(3.0, 4.0))
        val returnedStart = line.getStart()

        returnedStart.move(100.0, 100.0)

        assertEquals(0.0, line.getStart().getX())
        assertEquals(0.0, line.getStart().getY())
    }
}