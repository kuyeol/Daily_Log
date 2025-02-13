import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun getMyEvents(): Flow<Int> = flow {
    for (i in 1..3) {
        if (i == 2) throw RuntimeException("Error on $i")
        emit(i)
        delay(100)
    }
}

// 추가: 에러 발생 시에도 계속 실행되는 Flow
fun getNumbersWithErrors(): Flow<Int> = flow {
    for (i in 1..5) {
        if (i == 2 || i == 4) {
            throw RuntimeException("Error on $i")
        }
        emit(i)
        delay(100)
    }
}

suspend fun main() {
    val flow = getMyEvents()
    
    try {
        flow.collect { value ->
            println("Received $value")
        }
        println("My events are consumed successfully")
    } catch (e: Throwable) {
        println("Exception from the flow: $e")
    }
    
    // 대안: catch 연산자 사용
    println("\nUsing catch operator:")
    getMyEvents()
        .catch { e -> 
            println("Caught exception: $e")
            emit(-1) // 에러 발생 시 대체 값 방출
        }
        .collect { value ->
            println("Received $value")
        }
        
    println("\nContinuing after errors:")
    
    getNumbersWithErrors()
        .onEach { 
            println("Processing $it")
        }
        .catch { e -> 
            println("Error occurred: $e")
        }
        .onCompletion { 
            println("First flow completed")
        }
        .collect()
        
    println("\nRetrying after errors:")
    getNumbersWithErrors()
        .retry(2) { e ->
            println("Retrying after error: $e")
            true
        }
        .catch { e -> 
            println("Final error: $e")
        }
        .collect { value ->
            println("Received $value")
        }
}
