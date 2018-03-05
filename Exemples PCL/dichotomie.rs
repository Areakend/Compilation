struct tab {
  taille : i32,
  tableau : Vec<i32>
}

fn recherche_dichotomique_aux(tableau: Vec<i32>, valeur: i32, debut: i32, fin: i32) -> i32 {

  let milieu = (debut+fin)/2;

  while (debut < fin) {
    if (tableau[milieu] == valeur) {
      return milieu
    } else if (tableau[milieu] <= valeur){
      recherche_dichotomique_aux(tableau,valeur,debut,milieu)
    } else {
      recherche_dichotomique_aux(tableau,valeur,milieu,fin);
    }
  }
}

fn recherche_dichotomique(vecteur: tab, valeur : i32) -> i32 {
  recherche_dichotomique_aux(vecteur.tableau, valeur, 0, vecteur.taille-1);
}

fn main() {
  let v = tab {taille:5, tableau: vec![0, 3, 8, 52, 67]};
  print!(recherche_dichotomique(v, 52));
}
