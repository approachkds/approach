package co.kr.mono.training.astep02.baseselect;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;

import co.kr.mono.training.nvo.AreaSaleNVO;
import co.kr.mono.training.vo.SimpleVO;

public class MybatisTest {

	Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	private SqlSessionFactory sqlsessionFactory;
	
	@Before
	public void setUp() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/*
	 * @Ignore
	@Test
	public void selectTestOne() throws IOException {
		try (SqlSession session = sqlsessionFactory.openSession()) {
			AreaSaleVO areaSaleVo = session.selectOne("SelectBaseMapper.findAreaSales", "10");
			logger.info("Sale cnt : {}", areaSaleVo);
		}
	}
	*/
	
	/*
	@Ignore
	@Test
	public void selectOneVO() throws IOException {
		
		try (SqlSession session = sqlsessionFactory.openSession()){
			MsalesVo sale = session.selectOne("SelectBaseMapper.findMsale");
			logger.info("Sale Cnt : {} " , sale);
		}
	}
	*/
	
	/*
	@Ignore
	@Test
	public void selectTestList() throws IOException {
		
		try(SqlSession session = sqlsessionFactory.openSession()) {
			List<MsalesVo> sale = session.selectList("SelectBaseMapper.findMsale");
			logger.info("Sale Cnt : {} ", sale);
			
			sale.forEach(row -> {
				logger.info("-------------------------");
				logger.info("Data : {} | {} | {} |", 
				row.getProdId(), row.getProdNm(), row.getSaleCnt());
			});
		}
	}
	*/
	
	@Ignore
	@Test
	public void selectOne() throws IOException {
		try(SqlSession session = sqlsessionFactory.openSession()) {
			AreaSaleNVO areaSaleVo = session.selectOne("SelectNVOMapper.findAreaSales", "10");
			logger.info("Sale Cnt : {} ", areaSaleVo );
		}
	}
	
	@Ignore
	@Test
	public void selectMapTest() throws IOException {
		
		try(SqlSession session = sqlsessionFactory.openSession()) {
			
			List<Map<String, Object>> sale = session.selectList("SelectVOMapper.findMsaleMap");
			
			System.out.println(sale.toString());
			
			sale.forEach(row -> {
				logger.info("----------------------------");
				row.forEach((columnName, value) -> {
					logger.info("cloumnName = {}, value={}\n", columnName, value);
				});
			});
		}
	}
	
	@Ignore
	@Test
	public void selectMapCnt() throws IOException {
		
		try(SqlSession session = sqlsessionFactory.openSession()) {
			
			int saleCnt = session.selectOne("SelectDeptypeapper.examCount");
			
			System.out.println("출력건수 :" + saleCnt);
		}
	}
	
	@Ignore
	@Test
	public void selectMapperDate() throws IOException{
		
		try(SqlSession session = sqlsessionFactory.openSession()) {
			
			java.util.Date saleDate = session.selectOne("SelectDeptypeapper.examDate");
			System.out.println("현재시간 : org " + saleDate);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String decodeSdf = sdf.format(saleDate);
			System.out.println("현재시간 convert : " + decodeSdf);
		}
	}
	
	
	@Test
	public void timeConvert() {
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println("utilDate: " + utilDate);
		System.out.println("sqlDate:" + sqlDate);
	}
	
	@Test
	public void selectMapDate() throws IOException {
		
		try (SqlSession session = sqlsessionFactory.openSession()) {
			
			SimpleVO saleDate = session.selectOne("SelectCdmapper.examDate");
			System.out.println("현재시간 | db to_char(sysdate) -> String : " + saleDate.getCurrentStrDate());
			System.out.println("현재시간 | db sysdate -> java.util.Date : " + saleDate.getUtilCurrentDate());
			System.out.println("현재시간 | db sysdate -> java.sql.Date : " + saleDate.getSqlCurrentTimeStamp());
			System.out.println("현재시간 | db sysdate -> java.sql.TimeStamp 매핑: " + saleDate.getSqlCurrentTimeStamp());
			System.out.println("현재시간 | db timeStamp -> java.sql.TimeStamp 메핑 : " + saleDate.getSqlDbCurrentTimeStamp());
			
			java.sql.Timestamp cvtSaleDate = new java.sql.Timestamp(saleDate.getUtilCurrentDate().getTime());
			System.out.println("util.date -> dql.date" + cvtSaleDate);
			
			cvtSaleDate = new java.sql.Timestamp(saleDate.getUtilCurrentDate().getTime()+ (long) (1000 * 60 * 60 * 24)*1);
			System.out.println("util.date 다음날 -> sql.date : " + cvtSaleDate);
			System.out.println(saleDate.getUtilCurrentDate().getTime());
			
		}
	}
	
}
