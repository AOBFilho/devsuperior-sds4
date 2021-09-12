import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTable = () => {
  const [activePage, setActivePage] = useState(0);

  const [page, setPage] = useState<SalePage>({
    last: true,
    totalPages: 0,
    totalElements: 0,
    number: 0,
    first: true,
  });

  useEffect(() => {
    axios
      .get(`${BASE_URL}/sales?page=${activePage}&size=20&sort=date,desc`)
      .then((response) => {
        setPage(response.data);
      });
  }, [activePage]);

  const changePage = (index: number) => {
    setActivePage(index);
  };

  return (
    <>
      <Pagination page={page} onPageChange={changePage} />
      <div className="table-responsive">
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              <th>Data</th>
              <th>Vendedor</th>
              <th>Clientes visitados</th>
              <th>Negócios fechados</th>
              <th>Valor</th>
            </tr>
          </thead>
          <tbody>
            {page.content?.map((line) => {
              return (
                <tr key={line.id}>
                  <td>{formatLocalDate(line.date, "dd/MM/yyyy")}</td>
                  <td>{line.seller.name}</td>
                  <td>{line.visited}</td>
                  <td>{line.deals}</td>
                  <td>{line.amount.toFixed(2)}</td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </>
  );
};
export default DataTable;
