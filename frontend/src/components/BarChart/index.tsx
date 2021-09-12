import axios from "axios";
import { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { SaleSuccess } from "types/sale";
import { round } from "utils/format";
import { BASE_URL } from "utils/requests";

type SeriesData = {
  name: string;
  data: number[];
};

type ChartData = {
  labels: { categories: string[] };
  series: SeriesData[];
};

const BarChart = () => {
  const [chartData, setChartData] = useState<ChartData>({
    labels: {
      categories: [],
    },
    series: [{ name: "", data: [] }],
  });

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/success-sale`).then((response) => {
      const data = response.data as SaleSuccess[];
      const labelsResponse = data.map((a) => a.sellerName);
      const seriesReponse = data.map((a) =>
        round((100.0 * a.deals) / a.visited, 1)
      );
      setChartData({
        labels: {
          categories: labelsResponse,
        },
        series: [{ name: "% Sucesso", data: seriesReponse }],
      });
    });
  });

  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      },
    },
  };

  return (
    <Chart
      options={{ ...options, xaxis: chartData.labels }}
      series={chartData.series}
      type="bar"
      height="240"
    />
  );
};

export default BarChart;
