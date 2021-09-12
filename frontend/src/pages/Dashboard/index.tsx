import BarChart from "components/BarChart";
import DataTable from "components/DataTable";
import DonutChart from "components/DonutChart";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

const DashBoard = () => {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary py-3">DashBoard de Vendas</h1>
        <div className="row py-3">
          <div className="col sm-col-6">
            <h5 className="text-center text-secondary">Taxa de Sucesso(%)</h5>
            <BarChart />
          </div>
          <div className="col sm-col-6">
            <h5 className="text-center text-secondary">Todas as Vendas</h5>
            <DonutChart />
          </div>
        </div>
        <h2 className="text-primary py-3">Todas as Vendas</h2>
        <DataTable />
      </div>
      <Footer />
    </>
  );
};

export default DashBoard;
