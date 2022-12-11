class Square (var x: Int, var y: Int, var side: Int) : Figure(0)  {
    var color: Int = -1

    override fun resize(zoom: Int) {
        side *= zoom
        println("Размер сторон после масштабирования: $side")
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        if (centerX == x && centerY == y) { return }

        if(direction == RotateDirection.Clockwise) {
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
        return (side*side).toFloat()
    }
}