<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<!-- BOOTSTRAP -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<#-- FontAwesome -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css" integrity="sha512-5Hs3dF2AEPkpNAR7UiOHba+lRSJNeM2ECkwxUIxC1Q/FLycGTbNapWXB4tP889k5T5Ju8fs4b1P5z/iB4nMfSQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
		<link rel="stylesheet" href="/css/index.css">
		<title>Catalogo Prodotti</title>
</head>

<body>
	<div class="container">
		<h1>Catalogo Prodotti</h1>
		<div class="add_container">
			<h3 class="w-50">Lista Prodotti - Totale: ${totaleProdotti}</h3>
			<a class="d-block w-50" href="/prodotto/create"><span class="badge text-bg-success"><i class="fa-solid fa-plus"></i>Nuovo Prodotto</span></a>
		</div>
		<div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Nome</th>
						<th scope="col">Descrizione</th>
						<th class="text-center" scope="col">Prezzo</th>
						<th class="text-center" scope="col">Azioni</th>
					</tr>
				</thead>
				<tbody>
					<#list listaProdotti as prodotto>
						<tr>
							<td>
								${prodotto.nome}
							</td>
							<td>
								${prodotto.descrizione}
							</td>
							<td class="text-center">
								${prodotto.prezzo}
							</td>
							<td class="text-center">
								<a href="delete?id=${prodotto.id}" class="badge text-bg-danger">Elimina</a>
								<a href="edit?id=${prodotto.id}" class="badge text-bg-warning">Modifica</a>
							</td>
						</tr>
					</#list>
				</tbody>
			</table>
			<div>
				<#if currentPage gt 0>
					<a class="pagination" href="?page=${currentPage - 1}">Precedente</a>
				</#if>
				Pagina ${currentPage + 1} di ${totalPages}
				<#if currentPage + 1 lt totalPages>
					<a class="pagination" href="?page=${currentPage + 1}">Successiva</a>
				</#if>
			</div>
		</div>
	</div>
</body>

</html>