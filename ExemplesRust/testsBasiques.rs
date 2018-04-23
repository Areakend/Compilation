fn verifierPriorite(a:i32,b:i32,c:i32,d:i32,e:i32) -> bool {
  let res1 = a+b*c/d-2*d;
  let res2 = (a+((b*c)/d))-(2*d);

  let res3 = a+b*c/d-2*d-4||e;

  return (res1==res2);
}

fn verifierAssociativite(a:i32,b:i32,c:i32,d:i32,e:i32) {
  let res1 = a*b*c*d*e;
  let res2 = a*b/c*d/e;

  print!(res1);
  print!(res2);
}

fn testBooleen(t:bool,f:bool) -> bool {
  let res1 = t||t&&f;
  let res2 = (t||t)&&f;

  return (res1!=res2);
}

fn main() {
  let a = 2;
  let b = 4;
  let c = 5;
  let d = 9;
  let e = 17;

  let t = true;
  let f = false;

  print!(verifierPriorite(a,b,c,d,e));
  print!(verifierAssociativite(a,b,c,d,e));
  print!(testBooleen(t,f));
}
