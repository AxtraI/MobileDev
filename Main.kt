fun main() {

    val figure1: Figure = Rectangle(1,2,3,4)
    val figure2: Figure = Circle(0, 0, 2)
    val figure3: Figure = Square(1,4,2)

    println("Площадь равна: ${figure1.area()}")
    figure1.move (2,2)
    figure1.resize(2)
    figure1.rotate(RotateDirection.Clockwise,3,-3)

    println("Площадь равна: ${figure2.area()}")
    figure2.move (3,3)
    figure2.resize(2)
    figure2.rotate(RotateDirection.Clockwise,1,-1)

    println("Площадь равна: ${figure3.area()}")
    figure3.move (4,1)
    figure3.resize(2)
    figure3.rotate(RotateDirection.Clockwise,4,-1)
}