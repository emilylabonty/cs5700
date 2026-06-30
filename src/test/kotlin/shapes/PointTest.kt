package shapes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Test

class PointTest {

    @Test
    fun `point stores x and y values`() {
        val point = Point(3.0, 4.0)

        assertEquals(3.0, point.getX())
        assertEquals(4.0, point.getY())
    }

    @Test
    fun `point can be moved`() {
        val point = Point(3.0, 4.0)

        point.move(2.0, -1.0)

        assertEquals(5.0, point.getX())
        assertEquals(3.0, point.getY())
    }

    @Test
    fun `point can be cloned`() {
        val original = Point(3.0, 4.0)
        val clone = original.clone()

        assertNotSame(original, clone)
        assertEquals(original.getX(), clone.getX())
        assertEquals(original.getY(), clone.getY())
    }
}