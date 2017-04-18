/**
 * array = [3,9,5,6,10,8,7,1,2,4]의 1 ~ 6 사이의 합을 구하는 예
 *
 * let fenwick = FenwickTree(array)
 * fenwick.range(1, 6)
 */
public class FenwickTree {
    var orig: [Int];
    var tree: [Int];
    
    init(_ orig: [Int]) {
        self.orig = orig
        // 0번은 사용하지 않는다. 1번부터 사용한다. 그래야 비트 연산이 가능해진다.
        self.tree = [Int](repeating: 0, count: orig.count + 1)
        
        for i in 0..<orig.count {
            add(i, orig[i])
        }
        print(tree)
    }
    
    private func add(_ pos: Int, _ val: Int) {
        var position = pos + 1
        while position < tree.count {
            tree[position] += val;
            // 가장 하위의 비트값을 더한다.
            position += (position & -position)
        }
    }
    
    public func sum(_ pos: Int) -> Int {
        var position = pos + 1
        var sum = 0
        while position > 0 {
            sum += tree[position]
            // 가장 하위의 비트값을 뺀다.
            position &= (position - 1)
        }
        return sum
    }
    
    public func update(_ pos: Int, _ val: Int) {
        let diff = val - orig[pos]
        orig[pos] = val
        add(pos, diff)
    }
    
    public func range(_ leftBound: Int, _ rightBound: Int) -> Int {
        return sum(rightBound) - sum(leftBound - 1)
    }
}

