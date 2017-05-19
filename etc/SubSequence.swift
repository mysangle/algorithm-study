/**
 * findSubsequences("ab") -> ["ab", "a", "b", ""]
 */
func findSubsequences(_ a: String) -> [String] {
    return subsequence(a, 0, "")
}

func subsequence(_ a: String, _ index: Int, _ sub: String) -> [String] {
    guard a.characters.count != index else {
        return [sub]
    }
    
    var sub2 = sub
    let i = a.index(a.startIndex, offsetBy: index)
    sub2.append(a[i])
    
    let s1 = subsequence(a, index+1, sub2)
    let s2 = subsequence(a, index+1, sub)
    return s1 + s2
}

