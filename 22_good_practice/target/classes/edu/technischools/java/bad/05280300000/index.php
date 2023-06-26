<!DOCTYPE html>
<html lang="pl">
<head>
	<meta charset="pl">
	<link rel="stylesheet" href="style.css">
	<title>Obiekty sportowe</title>
</head>
<body>
	<header>
		<div class="panel">
			<ul>
				<li ><a class="styllist" href="index.php">Strona główna</a></li>
				<li ><a class="styllist" href="index.php">O nas</a></li>
				<li><a href="index.php">Kontakt</a></li>		
			</ul>
		</div>
	</header>

	<div class="centre">
		<div class="lewy">
			<h2>Lista Obiektów sportowych</h2>
			<ul>
			<?php 
			$conn=mysqli_connect("localhost","root","","sport");

				$r="SELECT id,nazwa FROM obiektsportowy";
				$rep=$conn->query($r);
				foreach($rep as $v){
					echo("<li><a href="."'index.php?id=".$v["id"]."'>".$v["nazwa"]."</a></li>");
				
			}
		
			?>
			<ul>
		</div>
		<div class="srodek">
			<?php 
			if(!empty($_GET["id"])){
				$idd=$_GET["id"];
				$rr='Select o.id, o.nazwa, o.adres , o.godzinyOtwarcia , o.obrazek ,rodzajObiektu.nazwa as "obiekt" From obiektsportowy o Left Join rodzajObiektu On o.rodzajObiektu=rodzajObiektu.id Where o.id='.$idd;
				$ress=$conn->query($rr);
				foreach($ress as $vvar){
					echo("<h2>".$vvar["nazwa"]."</h2>");
					echo("<h3>".$vvar["obiekt"]."</h3>");
					echo("<p>".$vvar["adres"]."</p>");
					echo("<img src='img/".$vvar["obrazek"]."'></img>");
					echo("<p>".$vvar["godzinyOtwarcia"]."</p>");

				}
			}
			if(empty($_GET["id"])){

				$okka="Select min(id) FROM rodzajobiektu;";
				$idddd=$conn->query($okka);
				foreach($idddd as $vvarr){
				}
				$rrr='Select o.id, o.nazwa, o.adres , o.godzinyOtwarcia , o.obrazek ,rodzajObiektu.nazwa as "obiekt" From obiektsportowy o Left Join rodzajObiektu On o.rodzajObiektu=rodzajObiektu.id Where o.id='.$vvarr["min(id)"];
				$resss=$conn->query($rrr);
				foreach($resss as $vvar){
					echo("<h2>".$vvar["nazwa"]."</h2>");
					echo("<h3>".$vvar["obiekt"]."</h3>");
					echo("<p>".$vvar["adres"]."</p>");
					echo("<img src='img/".$vvar["obrazek"]."'></img>");
					echo("<p>".$vvar["godzinyOtwarcia"]."</p>");
				}
			}

			?>

		</div>
		<div class="prawy"><h2>Dodaj nowy obiekt</h2>
			<form method="POST" href="index.php">
				<p>Nazwa obiektu:</p>
				<input class="inclass" type="text" name="nazwa">
				<p>Adres obiektu:</p>
				<input class="inclass" type="text" name="adres">
				<p>Rodzaj obiektu</p>
				<select class="inclass" name="rodzaj">
					<?php 
					$ok="SELECT id,nazwa FROM rodzajobiektu";
					$res=$conn->query($ok);
					foreach ($res as $var) {
						echo("<option value='".$var['id']."'>".$var['nazwa']."</option>");
					};
					?>
				</select>
				<p>Godziny Otwarcia:</p>
				<input class="inclass" type="text" name="godziny">
				<p>Obrazek:</p>
				<input class="in" type="submit" name="sub" value="Wyślij">
			</form>
			<?php 
			if(!empty($_POST)){
				$nazwa=$_POST["nazwa"];
				$adres=$_POST["adres"];
				$Rodzaj=$_POST["rodzaj"];
				$godziny=$_POST["godziny"];
				$kw2="SELECT id FROM `rodzajobiektu` WHERE id=$Rodzaj";
				$restt=$conn->query($kw2);
				foreach($restt as $vw){
				}
				$kw5="INSERT INTO `obiektsportowy` (`id`, `nazwa`, `adres`, `rodzajObiektu`, `godzinyOtwarcia`, `obrazek`) VALUES ('0', $nazwa, $adres, $Rodzaj, $godziny, 'default.jpeg')";
				$eeok=$conn->query($kw5);
			}
			
			$conn->close()
			?>
		</div>
	</div>

	<footer> <p>&copy 05280300000</footer>
</body>
</html>

