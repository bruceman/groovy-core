package groovy

import groovy.bugs.TestSupport

class ForLoopTest extends GroovyTestCase {

    def x
	
    void testRange() {
        x = 0

        for ( i in 0..9 ) {
            x = x + i
        }

        assert x == 45
    }

    void testRangeWithType() {
        x = 0

        for ( Integer i in 0..9 ) {
            assert i.getClass() == Integer
            x = x + i
        }

        assert x == 45
    }

    /** TODO - no longer applicable?

    void testRangeWithJdk15Style() {
        x = 0

        for ( i : 0..9 ) {
            x = x + i
        }

        assert x == 45
	}
	
	void testRangeWithJdk15StyleAndType() {
        x = 0

        for ( Integer i : 0..9 ) {
            assert i.getClass() == Integer
            x = x + i
        }

        assert x == 45
    }
    */
	
    void testList() {
        x = 0
		
        for ( i in [0, 1, 2, 3, 4] ) {
            x = x + i
        }

        assert x == 10
    }

    void testArray() {
        def array = (0..4).toArray()
        
        println "Class: ${array.getClass()} for array ${array}"
        
        x = 0
        
        for ( i in array ) {
            x = x + i
        }

        assert x == 10
    }
    
    void testIntArray() {
        def array = TestSupport.getIntArray()
        
        println "Class: ${array.getClass()} for array ${array}"
        
        x = 0
        
        for ( i in array ) {
            x = x + i
        }

        assert x == 15
    }
    
    void testString() {
        def text = "abc"
        
        def list = []
        for (c in text) {
            list.add(c)
        }
        
        assert list == ["a", "b", "c"]
    }
    
    void testVector() {
        def vector = new Vector()
        vector.addAll( [1, 2, 3] )
        
        def answer = []
        for (i in vector.elements()) {
            answer << i
        }
        assert answer == [1, 2, 3]
    }
    
    void testClassicFor() {
       def sum = 0
       for (int i=0; i<10; i++) {
         sum++
       }
       assert sum==10
       
       def list = [1,2]
       sum=0
       for (Iterator i = list.iterator();i.hasNext();){
         sum += i.next()
       }
       assert sum==3
    }
    
    void testClassicForNested() {
       def sum = 0
       for (int i=0; i<10; i++) {
         for (int j=0; j<10; j++) {
           sum++
         }
       }
       assert sum==100
    }
    
    void testClassicForWithContinue() {
      def sum1 = 0
      for (int i=0; i<10; i++) {
        if (i%2 == 0) continue
        sum1 += i
      }
      assert sum1 == 25
      
      // same as before, but with label
      def sum2 = 0
      test:
      for (int i=0; i<10; i++) {
        if (i%2 == 0) continue test
        sum2 += i
      }
      assert sum2 == 25      
      
    }

}
