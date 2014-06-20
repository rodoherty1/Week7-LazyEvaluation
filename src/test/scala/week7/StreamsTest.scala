
package week7

import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.GivenWhenThen

class StreamsTest extends WordSpec with ShouldMatchers with GivenWhenThen {
    
    "My Streams" should {
        "Confirm that only a stream's head is evaluated" in {
            given("A new MyStream object")
            val myStream  = new MyStream
            
            when ("I create a new Stream[Int] that ranges from 0 to 1000")
            val s = myStream.streamRange(0, 1000)

            then ("The number of evaluations that are performed is only 1 because only the head is evaluated and the tail remains unevaluated until it is explicitly requested")   
            myStream.getCountEvaluations should be (1)

            and ("when I request the head of the stream")
            s(0) should be (0)
            
            then ("the number of evaluations is still 1")
            myStream.getCountEvaluations should be (1)
            
            and ("when I request the third element of the stream")
            s(2) should be (2)
            
            then ("the count of evaluations is now three")
            myStream.getCountEvaluations should be (3)

            and ("when I request the second element of the stream")
            s(2) should be (2)
            
            then ("the count of evaluations is still three")
            myStream.getCountEvaluations should be (3)
        }
    }

}