struct triangle {
    cote1 : i32,
    cote2 : i32,
    cote3 : i32
}

fn main(a: i32, b: i32) {
    let mut i = 1;
    let mut result = a;
    while i < b
    {
        let result = result * a;
        let i = i + 1;
    }
}