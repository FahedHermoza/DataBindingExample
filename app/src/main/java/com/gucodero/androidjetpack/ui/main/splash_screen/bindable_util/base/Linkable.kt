package com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util.base

abstract class Linkable {

    var next: Linkable? = null

    val last: Linkable? get() {
        var result: Linkable? = this
        while (result?.next != null){
            result = result.next
        }
        return result
    }

}