var time = 0

var seconds = 10795

while (true){
    Thread.sleep(1000)
    seconds++

    updateTime()

    println(time.toString(2))
    println("${time.shr(12) and 0xf}:${time.shr(6) and 0x3f}:${time and 0x3f}")
}

//1000 101000 111001

fun updateTime() {
    var remainingSeconds = seconds
    val hours = remainingSeconds / 3600
    remainingSeconds -= hours * 3600
    val minutes = remainingSeconds / 60
    remainingSeconds -= minutes * 60
    val seconds = remainingSeconds
    time = hours.shl(12) or minutes.shl(6) or seconds
}
