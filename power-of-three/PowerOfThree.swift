
func isPowerOfThree(_ n: Int) -> Bool {
    if n == 0 {
        return false
    }
    if n == 1 {
        return true
    }
    var v = 3
    while v <= n {
        if v == n {
            return true
        }
        v = v * 3
    }
    return false
}

