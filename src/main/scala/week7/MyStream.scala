

package week7

class MyStream {
    var countEvaluations  = 0

    def streamRange (lo: Int, hi: Int): Stream[Int] = {
        countEvaluations += 1;
        
        if (lo >= hi) Stream()
        else {
            Stream.cons(lo, streamRange(lo + 1, hi))
        }
    }
    
    def getCountEvaluations = countEvaluations 
    
    def resetCountEvaluations = countEvaluations = 0
}