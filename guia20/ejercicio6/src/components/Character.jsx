export const Character = (props) => {
	return (
		<div className="col">
			<div className="card shadow-sm">
				<img
					className="bd-placeholder-img card-img-top"
					width="100%"
					src={props.char.image}
					alt="imagen"
				/>
				<div className="card-body">
					<h5 className="card-title">{props.char.name}</h5>
					<p className="card-text">{props.char.species}</p>
				</div>
			</div>
		</div>
	);
};
