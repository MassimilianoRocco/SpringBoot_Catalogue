<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<!-- BOOTSTRAP -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

	<link rel="stylesheet" href="/css/add.css">
	<title>Catalogo Prodotti</title>
</head>

<body>
	<div class="container">
		<h1 class="mb-4">Aggiungi Prodotto</h1>
		<form action="store" method="POST" id="datiProdotto">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="nome" class="mb-1">Nome</label>
					<input type="text" class="form-control" id="nome" name="nome" placeholder="Inserisci il nome del prodotto" required>
				</div>
				<div class="form-group col-md-6">
					<label for="descrizione" class="mb-1">Descrizione</label>
					<textarea class="form-control" id="descrizione" name="descrizione" placeholder="Descrizione del prodotto" rows="4" cols="50" required></textarea>
				</div>
			</div>
			<div class="form-group col-md-6">
				<label for="prezzo" class="mb-1">Prezzo</label>
				<input type="number" class="form-control" id="prezzo" name="prezzo" placeholder="Prezzo desiderato" required>
			</div>

			<button type="submit" form="datiProdotto" class="btn btn-primary mt-4">Aggiungi Prodotto</button>
		</form>
	</div>
</body>

</html>