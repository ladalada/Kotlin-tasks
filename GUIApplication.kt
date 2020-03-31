package app_GUI

/**
 * Написать приложение с GUI.
 * - Меню (кнопки выхода и вывода картинки)
 * - checkbox для выбора цвета поля
 * - кнопки очистки всего и выхода
 * */

import java.awt.*
import java.awt.Image;
import java.io.File
import javax.imageio.ImageIO
import javax.swing.*
import kotlin.system.exitProcess

class GUIApplication(title: String) : JFrame() {

    init {

        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)
        defaultCloseOperation = EXIT_ON_CLOSE
        setBounds(600,30,370,350)
        setLocationRelativeTo(null)
    }
}

class ImagePanel(image: Image) : JPanel() {

    private var img: Image? = image

    public override fun paintComponent(g: Graphics) {

        g.drawImage(img, 100, 100, 150, 150, null)
    }
}

fun main(args:Array<String>) {

    createFrame()
}

fun createButton(str: String) : Button {

    val button = Button()
    button.label = str
    return button
}

fun createFrame(){

    val frame = GUIApplication("GUI application")

    val menuBar = JMenuBar()
    val menu = JMenu("Menu")
    val panel1 = JPanel()

    val checkboxWhite = JCheckBox("White")
    checkboxWhite.isSelected = true
    checkboxWhite.background = Color.white
    panel1.add(checkboxWhite)

    val checkboxOrange = JCheckBox("Orange")
    checkboxOrange.background = Color.orange
    panel1.add(checkboxOrange)

    val checkboxCyan = JCheckBox("Cyan")
    checkboxCyan.background = Color.cyan
    panel1.add(checkboxCyan)

    var previous = checkboxWhite
    panel1.background = Color.white
    frame.contentPane.background = Color.white
    frame.background = Color.white

    checkboxWhite.addActionListener {

        previous.isSelected = false
        panel1.background = Color.white
        frame.contentPane.background = Color.white
        frame.background = Color.white
        previous = checkboxWhite
        checkboxWhite.isSelected = true
    }

    checkboxOrange.addActionListener {

        previous.isSelected = false
        panel1.background = Color.orange
        frame.contentPane.background = Color.orange
        frame.background = Color.orange
        previous = checkboxOrange
        checkboxOrange.isSelected = true
    }

    checkboxCyan.addActionListener {

        previous.isSelected = false
        panel1.background = Color.cyan
        frame.contentPane.background = Color.cyan
        frame.background = Color.cyan
        previous = checkboxCyan
        checkboxCyan.isSelected = true
    }

    panel1.setBounds(0,0,350,100)

    val pictureMenuItem = JMenuItem("Picture")
    val exitMenuItem = JMenuItem("Exit")

    val removeButton = createButton("Remove")
    val exitButton = createButton("Exit")

    pictureMenuItem.addActionListener {

        val image = ImageIO.read(File("src/app_GUI/flower.png"))
        val panel2 = ImagePanel(image)
        panel2.isVisible = true

        frame.contentPane.add(panel2)
        SwingUtilities.updateComponentTreeUI(frame)
    }

    exitMenuItem.addActionListener {

        exitProcess(0)
    }

    removeButton.addActionListener {

        checkboxWhite.doClick()
        checkboxWhite.isSelected = true
        frame.contentPane.remove(1)
        SwingUtilities.updateComponentTreeUI(frame)
    }

    exitButton.addActionListener { exitProcess(0) }

    menu.add(pictureMenuItem)
    menu.add(exitMenuItem)
    menuBar.add(menu)

    panel1.add(removeButton)
    panel1.add(exitButton)
    frame.add(panel1)

    frame.jMenuBar = menuBar
    frame.contentPane.layout = BorderLayout(1, 2)

    frame.contentPane.background = Color.white
    frame.background = Color.white
    frame.isVisible = true
    frame.isResizable = false
}