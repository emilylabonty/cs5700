package shapes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MovableTest {

    @Test
    fun `point can be treated as movable`() {
        val shape: Movable = Point(1.0, 2.0)

        shape.move(3.0, 4.0)

        val point = shape as Point
        assertEquals(4.0, point.getX())
        assertEquals(6.0, point.getY())
    }

    @Test
    fun `line can be treated as movable`() {
        val shape: Movable = Line(Point(0.0, 0.0), Point(3.0, 4.0))

        shape.move(1.0, 2.0)

        val line = shape as Line
        assertEquals(1.0, line.getStart().getX())
        assertEquals(2.0, line.getStart().getY())
        assertEquals(4.0, line.getEnd().getX())
        assertEquals(6.0, line.getEnd().getY())
    }

    @Test
    fun `rectangle can be treated as movable`() {
        val shape: Movable = Rectangle(Point(0.0, 0.0), Point(4.0, 3.0))

        shape.move(2.0, -1.0)

        val rectangle = shape as Rectangle
        assertEquals(2.0, rectangle.getCorner1().getX())
        assertEquals(-1.0, rectangle.getCorner1().getY())
        assertEquals(6.0, rectangle.getCorner2().getX())
        assertEquals(2.0, rectangle.getCorner2().getY())
    }

    @Test
    fun `square can be treated as movable through rectangle inheritance`() {
        val shape: Movable = Square(Point(0.0, 0.0), Point(4.0, 4.0))

        shape.move(1.0, 1.0)

        val square = shape as Square
        assertEquals(1.0, square.getCorner1().getX())
        assertEquals(1.0, square.getCorner1().getY())
        assertEquals(5.0, square.getCorner2().getX())
        assertEquals(5.0, square.getCorner2().getY())
    }

    @Test
    fun `ellipse can be treated as movable`() {
        val shape: Movable = Ellipse(Point(1.0, 2.0), 3.0, 4.0)

        shape.move(5.0, -1.0)

        val ellipse = shape as Ellipse
        assertEquals(6.0, ellipse.getCenter().getX())
        assertEquals(1.0, ellipse.getCenter().getY())
    }

    @Test
    fun `circle can be treated as movable through ellipse inheritance`() {
        val shape: Movable = Circle(Point(1.0, 2.0), 5.0)

        shape.move(3.0, 4.0)

        val circle = shape as Circle
        assertEquals(4.0, circle.getCenter().getX())
        assertEquals(6.0, circle.getCenter().getY())
    }

    @Test
    fun `triangle can be treated as movable`() {
        val shape: Movable = Triangle(
            Point(0.0, 0.0),
            Point(4.0, 0.0),
            Point(0.0, 3.0)
        )

        shape.move(2.0, -1.0)

        val triangle = shape as Triangle
        assertEquals(2.0, triangle.getPoint1().getX())
        assertEquals(-1.0, triangle.getPoint1().getY())
        assertEquals(6.0, triangle.getPoint2().getX())
        assertEquals(-1.0, triangle.getPoint2().getY())
        assertEquals(2.0, triangle.getPoint3().getX())
        assertEquals(2.0, triangle.getPoint3().getY())
    }

    @Test
    fun `all movable shapes implement movable`() {
        assertTrue(Point(0.0, 0.0) is Movable)
        assertTrue(Line(Point(0.0, 0.0), Point(1.0, 1.0)) is Movable)
        assertTrue(Rectangle(Point(0.0, 0.0), Point(4.0, 3.0)) is Movable)
        assertTrue(Square(Point(0.0, 0.0), Point(4.0, 4.0)) is Movable)
        assertTrue(Ellipse(Point(0.0, 0.0), 3.0, 4.0) is Movable)
        assertTrue(Circle(Point(0.0, 0.0), 5.0) is Movable)
        assertTrue(
            Triangle(
                Point(0.0, 0.0),
                Point(4.0, 0.0),
                Point(0.0, 3.0)
            ) is Movable
        )
    }
}