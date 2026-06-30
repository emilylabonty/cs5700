package shapes

class Point(
    private var x: Double,
    private var y: Double
) : Movable {

    fun getX(): Double {
        return x
    }

    fun getY(): Double {
        return y
    }

    fun clone(): Point {
        return Point(x, y)
    }

    override fun move(deltaX: Double, deltaY: Double) {
        x += deltaX
        y += deltaY
    }
}