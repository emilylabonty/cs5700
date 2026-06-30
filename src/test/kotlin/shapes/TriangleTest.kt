package shapes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class TriangleTest {

    @Test
    fun `triangle stores copies of points`() {
        val point1 = Point(0.0, 0.0)
        val point2 = Point(4.0, 0.0)
        val point3 = Point(0.0, 3.0)

        val triangle = Triangle(point1, point2, point3)

        assertNotSame(point1, triangle.getPoint1())
        assertNotSame(point2, triangle.getPoint2())
        assertNotSame(point3, triangle.getPoint3())
    }

    @Test
    fun `triangle calculates area`() {
        val triangle = Triangle(
            Point(0.0, 0.0),
            Point(4.0, 0.0),
            Point(0.0, 3.0)
        )

        assertEquals(6.0, triangle.getArea())
    }

    @Test
    fun `triangle cannot have zero area when points are collinear`() {
        assertThrows(IllegalArgumentException::class.java) {
            Triangle(
                Point(0.0, 0.0),
                Point(1.0, 1.0),
                Point(2.0, 2.0)
            )
        }
    }

    @Test
    fun `triangle cannot have zero area when all points are identical`() {
        assertThrows(IllegalArgumentException::class.java) {
            Triangle(
                Point(1.0, 1.0),
                Point(1.0, 1.0),
                Point(1.0, 1.0)
            )
        }
    }

    @Test
    fun `triangle can be moved`() {
        val triangle = Triangle(
            Point(0.0, 0.0),
            Point(4.0, 0.0),
            Point(0.0, 3.0)
        )

        triangle.move(2.0, -1.0)

        assertEquals(2.0, triangle.getPoint1().getX())
        assertEquals(-1.0, triangle.getPoint1().getY())
        assertEquals(6.0, triangle.getPoint2().getX())
        assertEquals(-1.0, triangle.getPoint2().getY())
        assertEquals(2.0, triangle.getPoint3().getX())
        assertEquals(2.0, triangle.getPoint3().getY())
    }

    @Test
    fun `returned points do not modify internal triangle points`() {
        val triangle = Triangle(
            Point(0.0, 0.0),
            Point(4.0, 0.0),
            Point(0.0, 3.0)
        )

        val point = triangle.getPoint1()
        point.move(100.0, 100.0)

        assertEquals(0.0, triangle.getPoint1().getX())
        assertEquals(0.0, triangle.getPoint1().getY())
    }
}