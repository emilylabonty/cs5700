package shapes

class Square(
    corner1: Point,
    corner2: Point
) : Rectangle(corner1, corner2) {

    init {
        validateSquare()
    }

    private fun validateSquare() {
        if (getWidth() != getHeight()) {
            throw IllegalArgumentException("A square must have equal width and height.")
        }
    }
}