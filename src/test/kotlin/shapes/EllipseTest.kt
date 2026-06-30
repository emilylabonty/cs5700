package shapes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import kotlin.math.PI

class EllipseTest {

    @Test
    fun `ellipse stores center and radii`() {
        val center = Point(1.0, 2.0)
        val ellipse = Ellipse(center, 3.0, 4.0)

        assertNotSame(center, ellipse.getCenter())
        assertEquals(1.0, ellipse.getCenter().getX())
        assertEquals(2.0, ellipse.getCenter().getY())
        assertEquals(3.0, ellipse.getRadiusX())
        assertEquals(4.0, ellipse.getRadiusY())
    }

    @Test
    fun `ellipse cannot have zero x radius`() {
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), 0.0, 4.0)
        }
    }

    @Test
    fun `ellipse cannot have zero y radius`() {
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), 3.0, 0.0)
        }
    }

    @Test
    fun `ellipse cannot have negative radius`() {
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), -3.0, 4.0)
        }
    }

    @Test
    fun `ellipse calculates area`() {
        val ellipse = Ellipse(Point(0.0, 0.0), 3.0, 4.0)

        assertEquals(PI * 3.0 * 4.0, ellipse.getArea())
    }

    @Test
    fun `ellipse can be moved`() {
        val ellipse = Ellipse(Point(1.0, 2.0), 3.0, 4.0)

        ellipse.move(5.0, -1.0)

        assertEquals(6.0, ellipse.getCenter().getX())
        assertEquals(1.0, ellipse.getCenter().getY())
    }

    @Test
    fun `returned center does not modify internal ellipse center`() {
        val ellipse = Ellipse(Point(1.0, 2.0), 3.0, 4.0)
        val center = ellipse.getCenter()

        center.move(100.0, 100.0)

        assertEquals(1.0, ellipse.getCenter().getX())
        assertEquals(2.0, ellipse.getCenter().getY())
    }
}