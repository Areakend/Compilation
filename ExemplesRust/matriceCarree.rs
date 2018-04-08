struct mat2_carree {
  t1 : Vec<i32>,
  t2 : Vec<i32>
}

fn determinant (m:mat2_carree) -> i32 {
  return m.t1[0]*m.t2[1]-m.t0[1]*m.t1[0];
}

fn estInversible(m:mat2_carree) -> bool {
  return (determinant(m)!=0);
}

fn inverserMatrice(m1:mat2_carree) -> mat2_carree {

  let m2 = mat2_carree {t1:vec![0, 0], t2:vec![0, 0]};

  if (estInversible(m1)) {
     let det = determinant(m1);
     let m2.t1[0] = m1.t2[1]/det;
     let m2.t2[0] = -m1.t2[0]/det;
     let m2.t1[1] = -m1.t1[1]/det;
     let m2.t2[1] = m1.t1[0]/det;
  }

  return m2;
}

fn resoudreSysteme(m:mat2_carree, b:Vec<i32>) {

  if (estInversible(m)) {
    let x = vec![0, 0];
    let m_inv = inverserMatrice(m);
    let i = 0;
    while (i<2) {
      let x[0] = x[0] + m_inv.t1[i]*b[i];
      let x[1] = x[1] + m_inv.t2[i]*b[i];
      let i = i+1
    }
    print!(x[0]);
    print!(x[1]);
  }
  else {
    print!(erreur);
  }
}

fn main() {
  let m = mat2_carree {t1: vec![2, 4], t1: vec![1, 6]};
  let b = vec![10, 8];
  resoudreSysteme(m,b);
}
