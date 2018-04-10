fn fibonacci_computation(generations : i32, previous : i32, pprevious : i32) -> i32
{
    if generations < 0
    {
        return previous;
    }

    return fibonacci_computation(generations - 1, previous + pprevious, previous);
}


fn fibonacci(generations : i32) -> i32
{
    let mut result;

    if generations == 0 || generations == 1
    {
        let result = generations;
    }

    else
    {
        let result = {
            fibonacci_computation(generations - 2, 1, 0)
        };
    }

    return result;
}

fn main() {
    print!(fibonacci(12));
}
