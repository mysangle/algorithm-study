public class ListNode {
    public var val: Int
    public var next: ListNode?
    public init(_ val: Int) {
        self.val = val
        self.next = nil
    }
}

func oddEvenList(_ head: ListNode?) -> ListNode? {
    guard head != nil else {
        return head
    }
    
    var odd = head
    var even = head!.next
    let firstEven = head!.next
    while even != nil && odd != nil {
        odd?.next = even?.next
        if even?.next == nil {
            break
        }
        even?.next = even?.next?.next
        
        even = even?.next
        odd = odd?.next
    }
    odd?.next = firstEven
    return head
}

