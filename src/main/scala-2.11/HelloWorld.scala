abstract class Person(name : String, age : Integer = 0){
    def getInfo(value : String) = {
        println(value)
    }
}

trait ScienceWork{
    def setNewAcademicDegree(degree: String) : String = degree + "123"
}

class Teacher(academicDegree: String) extends Person(academicDegree) with ScienceWork{
    def teach(condition : Condition) : String = {
        println(condition)
        return condition.toString
    }
}

case class Condition(condition : String)

class Student(course : Integer, isRecovered : Boolean = false){
    def study(mood : Boolean) : String = {
        return mood.toString
    }
}

object Student{
    def apply(name : String, age : Integer) : Student = {
        val std = new Student(4,true);
        return std;
    }
}

