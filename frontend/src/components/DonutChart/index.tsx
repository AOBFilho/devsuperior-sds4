import axios from "axios";
import Chart from "react-apexcharts";
import { SaleSum } from "types/sale";
import { BASE_URL } from "utils/requests";

type ChartData = {
  labels: string[];
  series: number[];
};

const DonutChart = () => {
  let chartData: ChartData = { labels: [], series: [] };

  // const mockData = {
  //   series: [477138, 499928, 444867, 220426, 473088],
  //   labels: ["Anakin", "Barry Allen", "Kal-El", "Logan", "Padmé"],
  // };

  axios.get(`${BASE_URL}/sales/amount-sale`).then((response) => {
    const data = response.data as SaleSum[];
    chartData.labels = data.map((a) => a.sellerName);
    chartData.series = data.map((a) => a.ammount);
    console.log(chartData);
  });

  const options = {
    legend: {
      show: true,
    },
  };

  return (
    <Chart
      options={{ ...options, labels: chartData.labels }}
      series={chartData.series}
      type="donut"
      height="240"
    />
  );
};

export default DonutChart;
