import { SalePage } from "types/sale";

type Prop = {
  page: SalePage;
  onPageChange: Function;
};

const Pagination = ({ page, onPageChange }: Prop) => {
  const numberPages = [];

  for (let i = 0; i < page.totalPages; i++) {
    if (i < 5) {
      numberPages.push(
        <li
          className={`page-item ${page.number === i ? "disabled" : ""}`}
          key={i}
        >
          <span className="page-link">{i + 1}</span>
        </li>
      );
    } else if (i + 1 === page.totalPages) {
      numberPages.push(
        <li className="page-item disabled" key="fim">
          <span className="page-link">...</span>
        </li>
      );
      numberPages.push(
        <li
          className={`page-item ${page.number === i ? "disabled" : ""}`}
          key={i}
        >
          <span className="page-link">{i + 1}</span>
        </li>
      );
    } else if (i === page.number) {
      numberPages.push(
        <li className="page-item disabled" key="meio">
          <span className="page-link">...</span>
        </li>
      );
      numberPages.push(
        <li className="page-item disabled" key={i}>
          <span className="page-link">{i + 1}</span>
        </li>
      );
    }
  }

  return (
    <nav>
      <ul className="pagination justify-content-center">
        <li className={`page-item ${page.first ? "disabled" : ""}`}>
          <button
            className="page-link"
            onClick={() => onPageChange(page.number - 1)}
          >
            Anterior
          </button>
        </li>
        {numberPages}
        <li className={`page-item ${page.last ? "disabled" : ""}`}>
          <button
            className="page-link"
            onClick={() => onPageChange(page.number + 1)}
          >
            Próxima
          </button>
        </li>
      </ul>
    </nav>
  );
};

export default Pagination;
