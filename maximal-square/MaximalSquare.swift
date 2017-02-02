func testSquare(_ matrix: [[Character]], _ startX: Int, _ startY: Int, _ maxX: Int, _ maxY: Int) -> Int {
    var xx = startX + 1
    var yy = startY + 1
    var m = 1
    outerLoop: while xx < maxX && yy < maxY {
        var x = xx - startX
        var y = 0
        var count = 0
        while y + startY < maxY && y <= x {
            if matrix[startX + x][startY + y] == "0" {
                break outerLoop
            }
            count += 1
            y += 1
        }
        y = y - 1
        x -= 1
        while x >= 0 {
            if (matrix[startX + x][startY + y] == "0") {
                break outerLoop
            }
            count += 1
            x -= 1
        }
        m = m + count
        xx += 1
        yy += 1
    }
    return m
}

func maximalSquare(_ matrix: [[Character]]) -> Int {
    var maximum = 0
    for x in 0..<matrix.count {
        for y in 0..<matrix[x].count {
            if matrix[x][y] != "0" {
                maximum = max(maximum, testSquare(matrix, x, y, matrix.count, matrix[x].count))
            }
        }
    }
    return maximum
}

