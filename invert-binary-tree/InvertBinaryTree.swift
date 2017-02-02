public class TreeNode {
    public var val: Int
    public var left: TreeNode?
    public var right: TreeNode?
    public init(_ val: Int) {
        self.val = val
        self.left = nil
        self.right = nil
    }
}

// recursive
func invertTree(_ root: TreeNode?) -> TreeNode? {
    let temp = root?.left
    root?.left = root?.right
    if let left = root?.left {
        root?.left = invertTree(left)
    }
    root?.right = temp
    if let right = root?.right {
        root?.right = invertTree(right)
    }
    return root
}

