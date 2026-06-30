package shapes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.math.PI

class AreaMeasurableTest {

    @Test
    fun `rectangle can be treated as area measurable`() {
        val shape: AreaMeasurable = Rectangle(Point(0.0, 0.0), Point(4.0, 3.0))

        assertEquals(12.0, shape.getArea())
    }

    @Test
    fun `square can be treated as area measurable through rectangle inheritance`() {
        val shape: AreaMeasurable = Square(Point(0.0, 0.0), Point(4.0, 4.0))

        assertEquals(16.0, shape.getArea())
    }

    @Test
    fun `ellipse can be treated as area measurable`() {
        val shape: AreaMeasurable = Ellipse(Point(0.0, 0.0), 3.0, 4.0)

        assertEquals(PI * 3.0 * 4.0, shape.getArea())
    }

    @Test
    fun `circle can be treated as area measurable through ellipse inheritance`() {
        val shape: AreaMeasurable = Circle(Point(0.0, 0.0), 5.0)

        assertEquals(PI * 25.0, shape.getArea())
    }

    @Test
    fun `triangle can be treated as area measurable`() {
        val shape: AreaMeasurable = Triangle(
            Point(0.0, 0.0),
            Point(4.0, 0.0),
            Point(0.0, 3.0)
        )

        assertEquals(6.0, shape.getArea())
    }

    @Test
    fun `area shapes implement area measurable`() {
        assertTrue(Rectangle(Point(0.0, 0.0), Point(4.0, 3.0)) is AreaMeasurable)
        assertTrue(Square(Point(0.0, 0.0), Point(4.0, 4.0)) is AreaMeasurable)
        assertTrue(Ellipse(Point(0.0, 0.0), 3.0, 4.0) is AreaMeasurable)
        assertTrue(Circle(Point(0.0, 0.0), 5.0) is AreaMeasurable)
        assertTrue(
            Triangle(
                Point(0.0, 0.0),
                Point(4.0, 0.0),
                Point(0.0, 3.0)
            ) is AreaMeasurable
        )
    }
}