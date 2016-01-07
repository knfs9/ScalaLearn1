abstract class Person(name : String, age : Integer = 0){
    def getInfo: String
}

trait ScienceWork{
    def setNewAcademicDegree(degree: String) : String = degree
}

class Teacher(name: String, age: Integer, var academicDegree: String) extends Person(academicDegree) with ScienceWork{
    override def getInfo : String = {
        "Teacher: " + name + ", age: " + age + ", academic Degree: " + academicDegree
    }
    def teach(condition : Condition) : String = {
        condition.toString
    }

}

case class Condition(condition : String)

class Student(name: String, age: Integer, val course: Integer, val isRecovered: Boolean = false) extends Person(name, age){
    def study(mood : Boolean) : String = {
        return mood.toString
    }
    override def getInfo: String = {
        "Student: " + name + ", age: " + age + ", is recovered: " + isRecovered
    }

}

object Student{
    def apply(name: String, age : Integer) = {
        new Student(name, age, 1)
    }

    def apply(name: String, age : Integer, course: Integer) = {
        new Student(name, age, course)
    }

    def apply(name: String, age : Integer, course: Integer, isRecovered: Boolean) = {
        new Student(name, age, course, isRecovered)
    }
    implicit class Converter(student: String){
        def toStudent: Student = {
            val split = student.split(":")
            split.size match {
                case 2 => Student(split(0),split(1).toInt)
                case 3 => Student(split(0),split(1).toInt,split(2).toInt)
                case 4 => Student(split(0),split(1).toInt,split(2).toInt, split(3).toBoolean)
                case _ => throw new Exception("Invalid argument")
            }
        }
    }

    def apply(source: String) = {
        source.toStudent
    }


}

object MainObj extends App{
    val student = Student("Kayumov Ildus:20")
    println(student.getInfo)

    def roulette(chamberSize: Int, isRevolver: Boolean, isLoaded: Boolean) = {
        (chamberSize, isRevolver, isLoaded) match {
            case (_,false,_) => "Ur idiot"
            case (_,_,false) => "Ur dumbass"
            case (6,true,true) => if(math.random > 0.5) "U died" else "U won"
            case _ => "WHAT?"
        }
    }

    println(roulette(4,false,false))
}


