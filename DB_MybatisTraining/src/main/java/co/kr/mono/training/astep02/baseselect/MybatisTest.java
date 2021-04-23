package co.kr.mono.training.astep02.baseselect;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import co.kr.mono.training.vo.AreaSaleVO;

public class MybatisTest {

	Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	private SqlSessionFactory sqlsessionFactory;
	
	@Before
	public void setUp() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void selectTestOne() throws IOException {
		try (SqlSession session = sqlsessionFactory.openSession()) {
			AreaSaleVO areaSaleVo = session.selectOne("SelectBaseMapper.findAreaSales", "10");
			logger.info("Sale cnt : {}", areaSaleVo);
		}
	}
	
	
}
