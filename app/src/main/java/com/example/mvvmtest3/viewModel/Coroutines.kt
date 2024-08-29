package com.example.mvvmtest3.viewModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/*
in ViewModel we will fetch data inside IO thread and will
get callback  in Main thread for this we have create this class
 */
object Coroutines {
    /*
    Generic Function, with type T which can take Any type ::fun<T:Any>
    work :- it is suspending function with no parameters and it returns T nullable:: work:suspend  (()->T?
    callback :- after executing suspend function we will get the result in the callback
    ::callback:((T?)->Unit)
    it will take result as parameters  and it will return nothing  so there is :: ->Unit

    Now this function we will call in viewModel to get list of Album
     */
    fun <T : Any> ioThenMain(work: suspend (() -> T?), callback: ((T?) -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            val data=CoroutineScope(Dispatchers.IO).async rt@{
                return@rt work()
            }.await()
            callback(data)
        }
    }
