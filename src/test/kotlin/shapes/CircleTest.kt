package shapes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import kotlin.math.PI

class CircleTest {

    @Test
    fun `circle uses same radius for x and y radius`() {
        val circle = Circle(Point(0.0, 0.0), 5.0)

        assertEquals(5.0, circle.getRadius())
        assertEquals(5.0, circle.getRadiusX())
        assertEquals(5.0, circle.getRadiusY())
    }

    @Test
    fun `circle cannot have zero radius`() {
        assertThrows(IllegalArgumentException::class.java) {
            Circle(Point(0.0, 0.0), 0.0)
        }
    }

    @Test
    fun `circle cannot have negative radius`() {
        assertThrows(IllegalArgumentException::class.java) {
            Circle(Point(0.0, 0.0), -5.0)
        }
    }

    @Test
    fun `circle calculates area`() {
        val circle = Circle(Point(0.0, 0.0), 5.0)

        assertEquals(PI * 25.0, circle.getArea())
    }

    @Test
    fun `circle can be moved`() {
        val circle = Circle(Point(1.0, 2.0), 5.0)

        circle.move(3.0, 4.0)

        assertEquals(4.0, circle.getCenter().getX())
        assertEquals(6.0, circle.getCenter().getY())
    }
}