package shapes

import kotlin.math.abs

class Square(
    corner1: Point,
    corner2: Point
) : Rectangle(corner1, corner2) {

    init {
        validateSquare()
    }

    private fun validateSquare() {
        if (abs(getWidth() - getHeight()) > EPSILON) {
            throw IllegalArgumentException("A square must have equal width and height.")
        }
    }

    private companion object {
        const val EPSILON = 0.000001
    }
}