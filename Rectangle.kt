class Rectangle(var x: Int, var y: Int, var width: Int, var height: Int) : Figure(0) {
    var color: Int = -1

    lateinit var name: String
    constructor(rect: Rectangle) : this(rect.x, rect.y, rect.width, rect.height)

    override fun resize(zoom: Int) {
        width *= zoom
        height *= zoom
        println("Новая ширина: $width, новая высота: $height")
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        if (centerX == x && centerY == y) { return }
        else if(direction == RotateDirection.Clockwise) {
            x = y - centerY + centerX.also { y = -1 * (x - centerX) + centerY }
        } else {
            x = -1 * (y - centerY) + centerX.also { y = x - centerX + centerY }
        }
        println("X: $x Y: $y после поворота")
    }

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
        println ("{$x, $y}")
    }

    override fun area(): Float {
        return (width*height).toFloat()
    }
}