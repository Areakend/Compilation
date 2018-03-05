struct triangle {
  cote1 : i32,
  cote2 : i32,
  cote3 : i32
}

fn cotesEgaux(x:i32, y:i32, z:i32) -> i32 {
  let nb = 0 ;
  if (x==y || y==z || x==z) {
    let nb = 2;
    if (x==y==z) {
      let nb = nb + 1;
    }
  }
  return nb;
}

fn testPythagore(x:i32, y:i32, z:i32) -> bool {
  if (x*x = y*y + z*z || y*y = x*x + z*z || z*z == x*x + y*y) {
    return true;
  }
  else {
    return false;
  }
}

fn estRectangle(triangle:triangle) -> bool {
  return testPythagore(triangle.cote1,triangle.cote2,triangle.cote3);
}

fn estIsocele(triangle:triangle) -> bool {
  return (cotesEgaux(triangle.cote1,triangle.cote2,triangle.cote3)>=2);
}

fn estEquilateral(triangle:triangle) -> bool {
  return (cotesEgaux(triangle.cote1,triangle.cote2,triangle.cote3)==3);
}

fn estQuelconque(triangle:triangle) -> bool {
  return (estIsocele(triangle) || estRectangle(triangle));
}

fn main() {
    let t1 = triangle {cote1: 3, cote2: 4, cote3: 5};
    let t2 = triangle {cote1: 2, cote2: 2, cote3: 5};
    let t3 = triangle {cote1: 2, cote2: 4, cote3: 7};

    print!(estRectangle(t1));
    print!(estIsocele(t1));
    print!(estEquilateral(t1));
    print!(estQuelconque(t1));

    print!(estIsocele(t2));

    print!(estQuelconque(t3));
}
