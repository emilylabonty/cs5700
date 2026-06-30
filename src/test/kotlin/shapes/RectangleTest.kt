package shapes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class RectangleTest {

    @Test
    fun `rectangle stores copies of corner points`() {
        val corner1 = Point(0.0, 0.0)
        val corner2 = Point(5.0, 3.0)
        val rectangle = Rectangle(corner1, corner2)

        assertNotSame(corner1, rectangle.getCorner1())
        assertNotSame(corner2, rectangle.getCorner2())
    }

    @Test
    fun `rectangle cannot have zero width`() {
        assertThrows(IllegalArgumentException::class.java) {
            Rectangle(Point(2.0, 0.0), Point(2.0, 5.0))
        }
    }

    @Test
    fun `rectangle cannot have zero height`() {
        assertThrows(IllegalArgumentException::class.java) {
            Rectangle(Point(0.0, 3.0), Point(5.0, 3.0))
        }
    }

    @Test
    fun `rectangle calculates width height and area`() {
        val rectangle = Rectangle(Point(1.0, 2.0), Point(6.0, 5.0))

        assertEquals(5.0, rectangle.getWidth())
        assertEquals(3.0, rectangle.getHeight())
        assertEquals(15.0, rectangle.getArea())
    }

    @Test
    fun `rectangle can be moved`() {
        val rectangle = Rectangle(Point(1.0, 2.0), Point(6.0, 5.0))

        rectangle.move(2.0, -1.0)

        assertEquals(3.0, rectangle.getCorner1().getX())
        assertEquals(1.0, rectangle.getCorner1().getY())
        assertEquals(8.0, rectangle.getCorner2().getX())
        assertEquals(4.0, rectangle.getCorner2().getY())
    }

    @Test
    fun `returned points do not modify internal rectangle points`() {
        val rectangle = Rectangle(Point(1.0, 2.0), Point(6.0, 5.0))
        val corner = rectangle.getCorner1()

        corner.move(100.0, 100.0)

        assertEquals(1.0, rectangle.getCorner1().getX())
        assertEquals(2.0, rectangle.getCorner1().getY())
    }
}