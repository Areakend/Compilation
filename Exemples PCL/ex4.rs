struct vecteur
{
    x: i32,
    y: i32
}

struct data
{
    v: vecteur,
    to_add: bool
}

fn addition_vecteurs(l : Vec<data>) -> vecteur
{
    let mut i = 0;
    let mut result = vecteur {x: 0, y: 0};

    while i < l.len()
    {
        if l[i].to_add
        {
            let result.x = result.x + l[i].v.x;
            let result.y = result.y + l[i].v.y;
        }
        let i = i + 1;
    }

    return result;
}

fn main()
{
    let d1 = data {v: vecteur{x: 0, y: 0}, to_add: true};
    let d2 = data {v: vecteur{x: 1, y: 1}, to_add: true};
    let d3 = data {v: vecteur{x: 2, y: 2}, to_add: false};
    let d4 = data {v: vecteur{x: 3, y: 4}, to_add: true};

    let l = vec![d1, d2, d3, d4];
    let result = addition_vecteurs(l);

    print!(result.x);
    print!(result.y);
}
