/**
 * isAnagram uses sorting
 * isAnagram2 uses hash table
 *
 * isAnagram2 is faster then isAnagram
 */
func isAnagram(_ s: String, _ t: String) -> Bool {
    return s.characters.sorted() == t.characters.sorted()
}

func isAnagram2(_ s: String, _ t: String) -> Bool {
    var ss = [Character: Int]()
    for c in s.characters {
        if ss[c] != nil {
            ss[c] = ss[c]! + 1
        } else {
            ss[c] = 1
        }
    }
    
    for c in t.characters {
        if ss[c] != nil {
            ss[c] = ss[c]! - 1
            if ss[c] == 0 {
                ss.removeValue(forKey: c)
            }
        } else {
            return false
        }
    }
    
    return ss.count == 0
}
