package com.jimmy.cryptocurrencies.domain.constants

enum class CryptocurrencyDirectory (val fullName: String){
    BTC (fullName = "Bitcoin"),
    ETH (fullName = "Ethereum"),
    USDT (fullName = "Tether"),
    USDC (fullName = "USD Coin"),
    BNB (fullName = "BNB"),
    BUSD (fullName = "Binance USD"),
    XRP (fullName = "XRP"),
    ADA (fullName = "Cardano"),
    SOL (fullName = "Solana"),
    DOGE (fullName = "Dogecoin"),
    DOT (fullName = "Polkadot"),
    DAI (fullName = "Dai"),
    MATIC (fullName = "Polygon"),
    SHIB (fullName = "Shiba Inu"),
    TRX (fullName = "TRON"),
    AVAX (fullName = "Avalanche"),
    WBTC (fullName = "Wrapped Bitcoin"),
    LEO (fullName = "UNUS SED LEO"),
    ATOM (fullName = "Cosmos"),
    UNI (fullName = "Uniswap"),
    ETC (fullName = "Ethereum clásico"),
    LTC (fullName = "Litecoin"),
    LINK (fullName = "Chainlink"),
    FTT (fullName = "FTX Token"),
    NEAR (fullName = "NEAR Protocol"),
    XL (fullName = "Stellar"),
    CRO (fullName = "Cronos"),
    XMR (fullName = "Monero"),
    ALGO (fullName = "Algorand"),
    BCH (fullName = "Bitcoin Cash"),
    BTCB (fullName = "Bitcoin BEP2"),
    LUNC (fullName = "Terra Classic"),
    XEC (fullName = "eCash"),
    USDD (fullName = "USDD"),
    MIOTA (fullName = "IOTA"),
    GRT (fullName = "The Graph"),
    HT (fullName = "Huobi Token"),
    USDN (fullName = "Neutrino USD"),
    CAKE (fullName = "PancakeSwap"),
    MKR (fullName = "Maker"),
    KLAY (fullName = "Klaytn"),
    SNX (fullName = "Synthetix"),
    NEO (fullName = "Neo"),
    FTM (fullName = "Fantom"),
    HNT (fullName = "Helium"),
    LDO (fullName = "Lido DAO"),
    RUNE (fullName = "THORChain"),
    PAXG (fullName = "PAX Gold"),
    CRV (fullName = "Curve DAO Token"),
    NEXO (fullName = "Nexo"),
    ENJ (fullName = "Enjin Coin"),
    BAT (fullName = "Basic Attention Token"),
    GT (fullName = "GateToken"),
    STX (fullName = "Stacks"),
    DASH (fullName = "Dash"),
    WAVES (fullName = "Waves"),
    RVN (fullName = "Ravencoin"),
    ZIL (fullName = "Zilliqa"),
    FEI (fullName = "Fei USD"),
    LRC (fullName = "Loopring"),
    MINA (fullName = "Mina"),
    TWT (fullName = "Trust Wallet Token"),
    KAVA (fullName = "Kava"),
    COMP (fullName = "Compound"),
    GMT (fullName = "STEPN"),
    BTG (fullName = "Bitcoin Gold"),
    XEM (fullName = "NEM"),
    LUNA (fullName = "Terra"),
    CELO (fullName = "Celo"),
    DCR (fullName = "Decred"),
    HOT (fullName = "Holo"),
    CEL (fullName = "Celsius"),
    INCH (fullName = "1inch	"),
    KSM (fullName = "Kusama"),
    USTC (fullName = "TerraClassicUSD"),
    GNO (fullName = "Gnosis"),
    APE (fullName = "ApeCoin"),
    FLOW (fullName = "Flow"),
    VET (fullName = "VeChain"),
    ICP (fullName = "Internet Computer"),
    FIL (fullName = "Filecoin"),
    CHZ (fullName = "Chiliz"),
    XTZ (fullName = "Tezos"),
    XDC (fullName = "XDC Network"),
    AR (fullName = "Arweave"),
    CVX (fullName = "Convex Finance"),
    BNX (fullName = "BinaryX"),
    YFI (fullName = "yearn.finance"),
    QTUM (fullName = "Qtum"),
    ANKR (fullName = "Ankr"),
    GUSD (fullName = "Gemini Dollar"),
    GALA (fullName = "Gala"),
    NXM (fullName = "NXM"),
    ROSE (fullName = "Oasis Network"),
    KDA (fullName = "Kadena"),
    GLM (fullName = "Golem"),
    TFUEL (fullName = "Theta Fuel"),
    ENS (fullName = "Ethereum Name Service"),
    IOTX (fullName = "IoTeX"),
    RPL (fullName = "Rocket Pool"),
    BTRST (fullName = "Braintrust"),
    MCO (fullName = "MCO"),
    MANA (fullName = "Decentraland"),
    HBAR (fullName = "Hedera"),
    QNT (fullName = "Quant"),
    EOS (fullName = "EOS"),
    SAND (fullName = "The Sandbox"),
    EGLD (fullName = "Elrond"),
    TUSD (fullName = "TrueUSD"),
    AAVE (fullName = "Aave"),
    THETA (fullName = "Theta Network"),
    AXS (fullName = "Axie Infinity"),
    USDP (fullName = "Pax Dollar"),
    BSV (fullName = "Bitcoin SV"),
    OKB (fullName = "OKB"),
    KCS (fullName = "KuCoin Token"),
    ZEC (fullName = "Zcash"),
    BTTOLD (fullName = "BitTorrent"),
    BTT (fullName = "BitTorrent (New)");

    companion object {
        fun getName(book: String): String{
            return try {
                valueOf(book).fullName
            } catch (ex: IllegalArgumentException) {
                book
            }
        }
    }
}




/*
FLUX (fullName = "Flux"),
Balancer	BAL	5.576	244.94M $	9.11M $	0.01%	+2.94%	-22.44%
ZEON	ZEON	0.0070967	241.24M $	425.86K $	0%	+1.22%	-14.23%
OMG Network	OMG	1.714	240.36M $	31.75M $	0.05%	+3.25%	-14.19%
Kyber Network Crystal v2	KNC	1.34913	239.58M $	154.38M $	0.22%	-0.05%	-28.35%
Harmony	ONE	0.019090	239.39M $	20.75M $	0.03%	+3.19%	-16.74%
Efinity Token	EFI	0.1176	235.40M $	1.69M $	0%	+1.72%	-9.93%
BORA	BORA	0.2512	232.79M $	4.90M $	0.01%	+2.43%	-13.24%
Reserve Rights	RSR	0.00543	229.57M $	7.89M $	0.01%	+2.26%	-15.10%
0x	ZRX	0.27094	229.29M $	15.77M $	0.02%	+3.26%	-17.58%
ICON	ICX	0.24466	224.94M $	7.02M $	0.01%	+3.38%	-15.72%
Hive	HIVE	0.514592	224.93M $	8.77M $	0.01%	+4.08%	-13.69%
JUST	JST	0.0252267	224.57M $	34.41M $	0.05%	+4.03%	-11.64%
Livepeer	LPT	9.05	223.80M $	7.51M $	0.01%	+3.90%	-18.12%
IOST	IOST	0.012019	223.37M $	9.93M $	0.01%	+2.02%	-15.04%
WEMIX	WEMIX	1.78129	220.19M $	20.59M $	0.03%	+3.67%	-16.07%
Symbol	XYM	0.0388	216.99M $	2.10M $	0%	+3.65%	-7.29%
Optimism	OP	0.926	216.88M $	156.16M $	0.22%	+3.47%	-27.05%
LINK	LN	34.1395	210.59M $	223.83K $	0%	+3.85%	-11.20%
Amp	AMP	0.00498	209.27M $	9.24M $	0.01%	+2.25%	-18.05%
Serum	SRM	0.7920	208.56M $	27.48M $	0.04%	+9.70%	-10.05%
Voyager Token	VGX	0.69	197.28M $	47.48M $	0.07%	+18.53%	-23.76%
Storj	STORJ	0.47222	195.09M $	14.96M $	0.02%	+4.57%	-17.15%
Ontology	ONT	0.2206	193.14M $	15.71M $	0.02%	+3.37%	-12.89%
Synapse	SYN	1.36158	190.31M $	3.03M $	0%	+6.44%	-24.55%
Ergo	ERG	3.249	188.66M $	3.00M $	0%	+5.02%	-27.84%
WAX	WAXP	0.0868	188.10M $	6.64M $	0.01%	+3.20%	-14.37%
Audius	AUDIO	0.226	186.89M $	5.33M $	0.01%	+2.26%	-19.93%
Siacoin	SC	0.003550	184.35M $	3.18M $	0%	+2.91%	-14.89%
Moonbeam	GLMR	0.4724	183.84M $	11.72M $	0.02%	+3.25%	-16.05%
Polymath	POLY	0.1963	181.74M $	10.53M $	0.02%	+2.20%	-24.99%
Immutable X	IMX	0.7689	180.64M $	17.85M $	0.03%	+4.71%	-12.84%
MXC	MXC	0.0675128	178.38M $	9.05M $	0.01%	+4.14%	-2.50%
Chia Network	XCH	34.65	177.23M $	9.07M $	0.01%	+5.53%	-6.91%
Horizen	ZEN	13.7667	176.63M $	8.70M $	0.01%	+3.47%	-16.14%
PAC Global	PAC	0.000291	175.08M $	361.75K $	0%	+5.09%	-13.07%
ABBC Coin	ABBC	0.170734	173.01M $	20.83M $	0.03%	+1.19%	-5.51%
SwissBorg	CHSB	0.177485	171.34M $	638.86K $	0%	+10.46%	-10.24%
Secret	SCRT	1.028	168.53M $	2.23M $	0%	+4.73%	-11.43%
Casper	CSPR	0.0279	168.07M $	6.91M $	0.01%	+7.31%	-6.08%
SXP	SXP	0.3339	166.13M $	30.77M $	0.04%	+4.54%	-16.15%
UMA	UMA	2.4040	165.41M $	7.65M $	0.01%	+3.39%	-16.55%
HUSD	HUSD	1.0367	159.77M $	745.47K $	0%	0%	-0.57%
WOO Network	WOO	0.13935	159.74M $	14.45M $	0.02%	+3.18%	-17.78%
PlayDapp	PLA	0.321	157.08M $	10.33M $	0.01%	0%	-13.84%
APENFT	NFT	0.00000054	150.22M $	32.11M $	0.05%	-1.82%	-6.74%
Pundi X (New)	PUNDIX	0.564	150.12M $	167.23M $	0.24%	+21.81%	-40.49%
DigiByte	DGB	0.009450	148.11M $	3.01M $	0%	+4.42%	-14.36%
The DAO	DAO	1.6015	147.32M $	3.57M $	0.01%	0%	-11.08%
Smooth Love Potion	SLP	0.0034	147.22M $	13.43M $	0.02%	+3.98%	-13.65%
SKALE Network	SKL	0.0385	142.64M $	13.80M $	0.02%	+4.90%	-19.50%
VVS Finance	VVS	0.00000552	142.30M $	4.05M $	0.01%	+5.95%	-9.83%
Dogelon Mars	ELON	0.00000026	140.62M $	3.44M $	0%	0%	-12.15%
Nervos Network	CKB	0.00403	135.62M $	7.65M $	0.01%	+9.19%	+4.21%
Astar	ASTR	0.0382	135.13M $	6.58M $	0.01%	+9.54%	-14.67%
SushiSwap	SUSHI	1.062	134.83M $	31.47M $	0.04%	+3.61%	-16.92%
Ellipsis (Old)	EPS	0.1679	134.73M $	1.89M $	0%	0%	-0.38%
Civic	CVC	0.13038	130.51M $	7.98M $	0.01%	+3.04%	-14.87%
Keep Network	KEEP	0.146	126.28M $	204.78K $	0%	+3.40%	-11.26%
Energy Web Token	EWT	4.204	126.20M $	1.35M $	0%	+9.56%	-5.80%
MediBloc	MED	0.019932	125.74M $	2.22M $	0%	+3.15%	-7.62%
Humanscape	HUM	0.142435	124.12M $	1.24M $	0%	+2.14%	-10.08%
STASIS EURO	EURS	0.98969	122.84M $	19.04M $	0.03%	+0.17%	-1.49%
Lisk	LSK	0.948	122.61M $	3.10M $	0%	+4.19%	-12.43%
Ultra	UOS	0.3970	121.74M $	1.93M $	0%	+4.45%	-9.07%
ssv.network	SSV	11.9292	119.29M $	5.67M $	0.01%	+6.08%	-34.08%
Injective Protocol	INJ	1.6	117.48M $	32.33M $	0.05%	+11.58%	-17.74%
Render Token	RNDR	0.457	116.19M $	12.32M $	0.02%	+4.33%	-18.88%
Syscoin	SYS	0.174	115.09M $	3.55M $	0.01%	+7.16%	-7.07%
MaidSafeCoin	MAID	0.25	113.89M $	3.53K $	0%	0%	-18.05%
CEEK VR	CEEK	0.1394	113.24M $	12.14M $	0.02%	+3.94%	-16.82%
Acala Token	ACA	0.223	113.10M $	2.80M $	0%	+1.55%	-4.90%
PlatonCoin	PLTC	0.989962	113.09M $	542.57K $	0%	0%	-0.01%
Bitcoin Standard Hashrate Token	BTCST	9.24	112.48M $	15.37M $	0.02%	+6.45%	-13.62%
ConstitutionDAO	PEOPLE	0.0221	111.77M $	68.28M $	0.10%	+14.48%	-1.42%
Spell Token	SPELL	0.00110	110.64M $	18.31M $	0.03%	+4.32%	-17.61%
Celer Network	CELR	0.01540	109.16M $	6.35M $	0.01%	+3.78%	-16.22%
COTI	COTI	0.0994	109.06M $	12.39M $	0.02%	+10.94%	-5.49%
Ren	REN	0.1079	107.69M $	14.43M $	0.02%	+4.05%	-18.19%
NuCypher	NU	0.1517	106.97M $	1.82M $	0%	+2.36%	-12.09%
Request	REQ	0.10703	106.80M $	2.86M $	0%	+3.64%	-16.59%

201		Request	REQ	0.1071	106.94M $	2.87M $	0%	+4.19%	-16.41%
202		Ontology Gas	ONG	0.334211	106.69M $	4.82M $	0.01%	+3.99%	-9.66%
203		Nano	XNO	0.798	106.52M $	3.36M $	0%	+4.31%	-11.72%
204		MVL	MVL	0.004849	105.53M $	1.72M $	0%	+9.68%	-15.68%
205		MetisDAO	METIS	23.93	104.88M $	5.64M $	0.01%	+4.87%	-18.89%
206		Wrapped Velas	WVLX	0.0459537	104.74M $	10.59K $	0%	+0.95%	+9.54%
207		USDX [Kava]	USDX	0.933337	104.13M $	248.36K $	0%	-0.09%	-1.20%
208		Centrifuge	CFG	0.326569	103.73M $	472.67K $	0%	-0.39%	-1.13%
209		Venus USDC	vUSDC	0.0216186	103.14M $	0 $	0%	0%	+0.04%
210		LooksRare	LOOKS	0.219	101.71M $	6.57M $	0.01%	+5.80%	-24.97%
211		Diamond Launch	DLC	0.101608	101.61M $	1.27M $	0%	+4.87%	+1.94%
212		Radio Caca	RACA	0.000307	100.69M $	7.32M $	0.01%	+2.80%	-18.00%
213		Function X	FX	0.241272	98.67M $	727.37K $	0%	+4.83%	-16.06%
214		Orbs	ORBS	0.0342229	98.45M $	1.56M $	0%	+1.58%	-13.11%
215		Ardor	ARDR	0.09785	98.25M $	2.10M $	0%	+3.93%	-13.90%
216		Tribe	TRIBE	0.2165	98.10M $	1.56M $	0%	-0.64%	-7.27%
217		iExec RLC	RLC	1.2102	97.73M $	16.92M $	0.02%	+5.86%	-15.00%
218		AVINOC	AVINOC	0.250166	97.38M $	655.75K $	0%	+0.31%	-2.08%
219		Status	SNT	0.028354	97.20M $	8.01M $	0.01%	+4.92%	-15.35%
220		Rakon	RKN	0.39679	96.36M $	5.26K $	0%	+4.30%	+13.43%
221		Conflux	CFX	0.0457	96.02M $	11.54M $	0.02%	+7.80%	-15.10%
222		Ocean Protocol	OCEAN	0.157	95.89M $	5.54M $	0.01%	+4.95%	-14.85%
223		Uquid Coin	UQC	9.49761	94.98M $	4.49M $	0.01%	+8.82%	-8.02%
224		Reef	REEF	0.00475	94.90M $	48.63M $	0.07%	-6.28%	-1.56%
225		Powerledger	POWR	0.1952	94.73M $	4.37M $	0.01%	+4.44%	-16.63%
226		WINkLink	WIN	0.000098	94.45M $	33.09M $	0.05%	+2.83%	-9.90%
227		XYO	XYO	0.007311	93.69M $	678.40K $	0%	+0.87%	-11.81%
228		Hxro	HXRO	0.218476	93.62M $	433.54K $	0%	+7.68%	+15.69%
229		Prom	PROM	5.63371	92.67M $	3.83M $	0.01%	+1.42%	-20.04%
230		Numeraire	NMR	15.5014	91.87M $	5.15M $	0.01%	+5.40%	-14.04%
231		Dent	DENT	0.000923	91.23M $	6.15M $	0.01%	+6.25%	-9.56%
232		Wrapped Everscale	WEVER	0.0738089	90.92M $	1.57M $	0%	+0.96%	-7.48%
233		Everscale	EVER	0.0738067	90.92M $	9.97M $	0.01%	+0.83%	-7.75%
234		Chainbing	CBG	2.75483	90.91M $	704.41K $	0%	+0.23%	-2.36%
235		MX TOKEN	MX	0.907114	90.71M $	2.19M $	0%	+2.70%	-8.17%
236		Telcoin	TEL	0.001358	89.68M $	985.75K $	0%	+5.29%	-7.11%
237		Constellation	DAG	0.070398	89.01M $	418.30K $	0%	+3.35%	-12.97%
238		QuarkChain	QKC	0.013917	88.47M $	17.63M $	0.03%	+18.11%	+14.84%
239		Maple	MPL	19.91	88.26M $	1.52M $	0%	-1.87%	-11.80%
240		Bancor	BNT	0.44210	88.17M $	5.34M $	0.01%	+2.96%	-10.55%
241		Prometeus	PROM	5.65	88.10M $	5.27M $	0%	+1.92%	+7.39%
242		Project Galaxy	GAL	2.508	87.88M $	34.88M $	0.05%	+4.50%	-14.03%
243		Chromia	CHR	0.1546	87.71M $	20.61M $	0.03%	+4.38%	-15.04%
244		Cartesi	CTSI	0.1385	86.80M $	5.20M $	0.01%	+1.54%	-10.56%
245		Anyswap	ANY	12.3	86.12M $	604.51K $	0%	0%	-12.98%
246		Steem	STEEM	0.21401	85.22M $	7.51M $	0.01%	+1.97%	-7.94%
247		Frax Share	FXS	5.249	85.13M $	9.32M $	0.01%	+0.34%	-15.64%
248		Coin98	C98	0.392	84.97M $	43.25M $	0.06%	+6.22%	-11.32%
249		API3	API3	1.505	84.78M $	5.77M $	0.01%	+5.09%	-17.34%
250		Biconomy	BICO	0.439314	83.89M $	7.67M $	0.01%	+1.92%	-14.28%
251		Seedify.fund	SFUND	2.33475	83.59M $	2.84M $	0%	+4.02%	-4.31%
252		dYdX	DYDX	1.249	81.84M $	71.98M $	0.10%	+4.34%	-22.35%
253		NEST Protocol	NEST	0.0279514	81.39M $	3.35M $	0%	-2.26%	-9.88%
254		Aurora	AURORA	1.15188	81.20M $	456.58K $	0%	-0.56%	-17.33%
255		FUNToken	FUN	0.007417	80.96M $	3.96M $	0.01%	+2.12%	-7.87%
256		WazirX	WRX	0.204	80.58M $	8.44M $	0.01%	+8.92%	-4.05%
257		Orbit Chain	ORC	0.130838	80.44M $	1.44M $	0%	+3.70%	-14.22%
258		Vulcan Forged PYR	PYR	3.37	80.15M $	16.42M $	0.02%	+1.81%	-17.98%
259		Rally	RLY	0.0235	80.06M $	1.32M $	0%	-0.84%	-20.24%
260		Biswap	BSW	0.2897	79.19M $	6.06M $	0.01%	+2.55%	-8.38%
261		Augur	REP	7.08	77.95M $	5.29M $	0.01%	+3.35%	-14.35%
262		Pirate Chain	ARRR	0.4037	77.52M $	106.69K $	0%	-0.20%	-16.00%
263		Revain	REV	0.00090	77.04M $	997.24K $	0%	-2.17%	-3.17%
264		Raydium	RAY	0.569	76.97M $	10.58M $	0.02%	+4.79%	-15.55%
265		Euro Coin	EUROC	1.00319	76.69M $	370.80K $	0%	+0.09%	-1.16%
266		Shentu	CTK	0.894	76.18M $	3.65M $	0.01%	+4.20%	-9.45%
267		sUSD	SUSD	1.00334	75.83M $	3.43M $	0%	-0.53%	-0.50%
268		Divi	DIVI	0.02492	75.67M $	175.30K $	0%	+4.89%	+50.49%
269		Stratis	STRAX	0.523	74.15M $	2.76M $	0%	+4.18%	-16.32%
270		Persistence	XPRT	0.604	73.11M $	726.51K $	0%	+0.62%	-7.98%
271		Loom Network	LOOM	0.05673	73.05M $	21.43M $	0.03%	+2.49%	-41.27%
272		LUKSO	LYXe	4.79808	72.96M $	580.15K $	0%	+3.80%	-12.75%
273		Adshares	ADS	2.37258	72.69M $	1.20M $	0%	+2.15%	-12.68%
274		Metal	MTL	1.082	71.81M $	6.34M $	0.01%	+4.44%	-15.08%
275		JOE	JOE	0.218788	71.26M $	3.21M $	0%	+1.08%	-8.00%
276		Radicle	RAD	2.06	71.18M $	3.55M $	0.01%	+2.90%	-16.43%
277		ZB Token	ZB	0.0998	71.13M $	0 $	0%	-2.73%	0%
278		StormX	STMX	0.006588	71.02M $	5.70M $	0.01%	+3.77%	-13.08%
279		Ampleforth Governance Token	FORTH	4.64116	71.00M $	4.82M $	0.01%	+1.55%	-3.52%
280		Stargate Finance	STG	0.532324	70.94M $	21.86M $	0.03%	+3.26%	-16.86%
281		WhiteCoin	XWC	0.09591	70.88M $	726.74K $	0%	+10.08%	-37.48%
282		renBTC	RENBTC	42,049.39	70.57M $	3.63M $	0.01%	-1.19%	-11.68%
283		Veritaseum	VERI	32.665	70.57M $	10.22K $	0%	+2.68%	+9.18%
284		Terran Coin	TRR	0	70.30M $	8.18M $	0.01%	0%	-5.00%
285		STP	STPT	0.0422758	69.70M $	4.31M $	0.01%	+1.90%	-17.81%
286		Bifrost	BFC	0.064437	68.97M $	693.79K $	0%	+5.67%	-10.28%
287		Orchid	OXT	0.0995	68.74M $	3.34M $	0%	+2.58%	-12.32%
288		Peculium	PCL	0.006151	68.59M $	0 $	0%	+5.38%	0%
289		inSure DeFi	SURE	0.00254098	68.07M $	702.22K $	0%	+4.31%	-20.76%
290		ASD	ASD	0.10299	67.99M $	2.02M $	0%	+0.84%	+20.98%
291		aelf	ELF	0.13174	67.92M $	9.43M $	0.01%	+3.73%	-13.72%
292		MobileCoin	MOB	0.913	67.62M $	600.85K $	0%	+3.28%	-9.20%
293		OriginTrail	TRAC	0.183282	67.08M $	805.86K $	0%	+0.76%	-10.42%
294		VeThor Token	VTHO	0.00146046	66.64M $	1.52M $	0%	+3.40%	-8.97%
295		Aragon	ANT	1.68200	66.59M $	12.03M $	0.02%	+3.12%	-13.15%
296		Creditcoin	CTC	0.313106	64.89M $	5.83M $	0.01%	+6.52%	-10.03%
297		NKN	NKN	0.091918	64.28M $	3.01M $	0%	+6.34%	-14.10%
298		Freeway Token	FWT	0.0063013	63.01M $	139.57K $	0%	-3.89%	-6.92%
299		Liquity	LQTY	0.7306	62.66M $	608.59K $	0%	+0.06%	-13.06%
300		Fetch.ai	FET	0.0829	61.80M $	7.94M $	0.01%	+1.38%	-9.37%
301		Splintershards	SPS	0.0755701	61.71M $	2.11M $	0%	+4.41%	-2.67%
302		TitanSwap	TITAN	1.114	61.15M $	9.92M $	0.01%	+7.95%	+10.95%
303		SingularityNET	AGIX	0.057063	60.88M $	2.37M $	0%	+10.44%	+2.02%
304		Alchemy Pay	ACH	0.01196	60.86M $	8.89M $	0.01%	+4.07%	-8.19%
305		MAGIC	MAGIC	0.3446	60.86M $	2.66M $	0%	+7.19%	-30.80%
306		RSK Smart Bitcoin	RBTC	19,429.8	60.77M $	28.76K $	0%	+5.45%	-12.88%
307		XCAD Network	XCAD	1.90331	60.55M $	2.45M $	0%	+2.02%	-4.58%
308		Melon	MLN	20.181	59.58M $	6.42M $	0%	-1.34%	+5.14%
309		Mdex	MDX	0.064	58.92M $	3.48M $	0%	+5.93%	-10.97%
310		Venus BUSD	vBUSD	0.0216367	58.31M $	0 $	0%	-0.03%	0%
311		cVault.finance	CORE	5,883.43	58.16M $	25.93K $	0%	+5.57%	-2.64%
312		Moonriver	MOVR	10.87	57.82M $	3.68M $	0.01%	+2.70%	-13.93%
313		SOMESING	SSX	0.02163	57.76M $	680.19K $	0%	+1.74%	-12.18%
314		Alien Worlds	TLM	0.0221	57.36M $	8.37M $	0.01%	+3.42%	-12.32%
315		XSGD	XSGD	0.733643	57.21M $	521.13K $	0%	+0.64%	+3.82%
316		Dawn Protocol	DAWN	0.765772	57.02M $	978.55K $	0%	+1.52%	-13.62%
317		Metacraft	MCT	1.08164	56.96M $	1.92M $	0%	-15.61%	-43.69%
318		Strike	STRK	16.9994	56.92M $	1.58M $	0%	+3.07%	-9.96%
319		Everipedia	IQ	0.005110	56.85M $	9.73M $	0.01%	0%	-9.19%
320		UFO Gaming	UFO	0.00000220	56.61M $	1.48M $	0%	+3.92%	-17.99%
321		Saitama	SAITAMA	0.00146253	56.46M $	4.23M $	0.01%	+0.68%	-20.98%
322		Origin Protocol	OGN	0.145	56.32M $	13.11M $	0.02%	+3.42%	-17.72%
323		Santos FC Fan Token	SANTOS	12.33	56.20M $	35.25M $	0.05%	+5.88%	+1.95%
324		Decentralized Social	DESO	6.2971	55.95M $	647.78K $	0%	+4.60%	+6.08%
325		MyNeighborAlice	ALICE	1.82	55.83M $	36.09M $	0.05%	+2.59%	-14.98%
326		Metadium	META	0.0330659	55.79M $	1.09M $	0%	+2.44%	-12.14%
327		Propy	PRO	0.65768	55.35M $	4.36M $	0.01%	+1.09%	-5.32%
328		Venus	XVS	4.56	55.33M $	7.17M $	0.01%	-4.80%	-7.58%
329		HedgeTrade	HEDG	0.32	55.33M $	552.99 $	0%	+5.29%	-4.49%
330		Verge	XVG	0.00332	54.86M $	1.31M $	0%	+2.47%	-8.28%
331		1eco	1ECO	2.07215	54.79M $	31.73K $	0%	-0.59%	-0.54%
332		Vai	VAI	0.948624	54.54M $	1.50K $	0%	-0.18%	-0.99%
333		Ark	ARK	0.38200	54.44M $	3.43M $	0%	+4.10%	-18.20%
334		Sologenic	SOLO	0.1537	54.06M $	847.67K $	0%	0%	-7.42%
335		SONM	SNM	0.369957	53.88M $	89.29K $	0%	-1.13%	-22.01%
336		Aavegotchi	GHST	1.1936	53.83M $	6.76M $	0.01%	+0.33%	-2.05%
337		Aergo	AERGO	0.12939	53.46M $	7.75M $	0.01%	+4.02%	-33.36%
338		Utrust	UTK	0.106997	52.39M $	1.58M $	0%	+3.21%	-10.26%
339		Bloktopia	BLOK	0.003	52.36M $	1.20M $	0%	+2.49%	-10.64%
340		MOBOX	MBOX	0.654	52.06M $	11.79M $	0.02%	+4.31%	-4.38%
341		Perpetual Protocol	PERP	0.57	51.66M $	4.66M $	0.01%	+4.55%	-18.15%
342		Celo Dollar	CUSD	0.994592	51.62M $	478.27K $	0%	+0.18%	-0.13%
343		Hifi Finance	MFT	0.005102	51.32M $	7.69M $	0.01%	+5.39%	-18.38%
344		MovieBloc	MBL	0.00354784	51.19M $	2.19M $	0%	+2.98%	-12.04%
345		Boba Network	BOBA	0.29670	51.13M $	1.13M $	0%	+3.30%	-11.84%
346		Electroneum	ETN	0.002837	51.12M $	36.58K $	0%	+3.04%	+0.56%
347		RSK Infrastructure Framework	RIF	0.0563587	51.01M $	1.18M $	0%	+3.81%	-13.43%
348		GlitzKoin	GTN	0.205598	50.89M $	23.01K $	0%	-3.30%	-7.91%
349		World Mobile Token	WMT	0.208046	50.75M $	739.28K $	0%	+0.37%	-5.02%
350		BarnBridge	BOND	5.21116	50.60M $	9.47M $	0.01%	-0.07%	-15.49%
351		S.S. Lazio Fan Token	LAZIO	5.8969	50.51M $	16.11M $	0.02%	+4.30%	-22.26%
352		SuperFarm	SUPER	0.1253	50.41M $	3.45M $	0%	+3.38%	-13.45%
353		CONUN	CON	0.0173478	50.26M $	1.90M $	0%	+1.65%	-8.67%
354		Beta Finance	BETA	0.09345	50.01M $	2.39M $	0%	+2.84%	-12.34%
355		Badger DAO	BADGER	3.98	49.81M $	4.12M $	0.01%	+3.92%	-13.36%
356		Wirex Token	WXT	0.00489	49.04M $	197.12K $	0%	+2.30%	-6.95%
357		Sun (New)	SUN	0.00560645	48.78M $	23.88M $	0.03%	+2.24%	-9.08%
358		Alpha Finance Lab	ALPHA	0.1085	48.32M $	2.77M $	0%	+5.75%	-14.99%
359		EFFORCE	WOZX	0.0906	47.99M $	593.95K $	0%	+0.32%	-2.59%
360		ThunderCore	TT	0.00503177	47.87M $	3.85M $	0.01%	+2.88%	-12.97%
361		Telos	TLOS	0.176613	47.71M $	3.42M $	0%	+1.07%	-4.00%
362		Origin Dollar	OUSD	0.996421	47.08M $	333.83K $	0%	+0.20%	+0.21%
363		Dusk Network	DUSK	0.1146	47.08M $	2.51M $	0%	+3.24%	-14.55%
364		Polkastarter	POLS	0.474	46.88M $	2.25M $	0%	+3.49%	-11.32%
365		Sport and Leisure	SNL	0.716042	46.64M $	0 $	0%	+5.38%	-17.08%
366		Dero	DERO	4.23574476	46.62M $	104.17K $	0%	+5.29%	-17.13%
367		Ampleforth	AMPL	0.9908	45.38M $	834.81K $	0%	+4.24%	-21.20%
368		Chrono.tech	TIME	63.7632	45.28M $	956.82K $	0%	-2.26%	+11.61%
369		GXChain	GXC	2.21	45.05M $	2.51K $	0%	-20.22%	-4.90%
370		CargoX	CXO	0.215116	44.65M $	2.60K $	0%	+3.03%	-8.96%
371		Yield Guild Games	YGG	0.384	44.52M $	12.77M $	0.02%	+0.92%	-19.74%
372		AXEL	AXEL	0.155197	43.94M $	72.51K $	0%	+4.42%	-10.38%
373		H2O DAO	H2O	0.3028	43.91M $	374.42K $	0%	+1.00%	+3.06%
374		Mines of Dalarnia	DAR	0.2103	43.82M $	13.22M $	0.02%	+3.35%	-15.52%
375		Verasity	VRA	0.0042305	43.76M $	3.61M $	0.01%	+0.85%	-12.89%
376		RSS3	RSS3	0.128626	43.65M $	817.71K $	0%	-0.85%	-9.27%
377		Marlin	POND	0.01117	43.40M $	6.56M $	0.01%	+3.71%	-6.21%
378		Alpaca Finance	ALPACA	0.305474	43.26M $	21.27M $	0.03%	+2.97%	+7.27%
379		Locus Chain	LOCUS	0.05110	42.97M $	1.25M $	0%	-1.73%	-16.82%
380		ONUS	ONUS	0.442149	42.94M $	7.28K $	0%	-0.54%	-3.40%
381		DeFi Pulse Index	DPI	76.76	42.91M $	581.20K $	0%	+3.78%	-15.18%
382		FC Porto Fan Token	PORTO	5.5179	42.91M $	13.76M $	0.02%	+5.01%	-19.64%
383		e-Radix	EXRD	0.0582776	42.82M $	222.29K $	0%	+6.45%	-7.81%
384		IDEX	IDEX	0.063238	42.61M $	3.96M $	0.01%	+1.78%	-7.77%
385		Keep3rV1	KP3R	100.09	42.46M $	2.93M $	0%	+4.43%	-11.79%
386		BakeryToken	BAKE	0.2186	42.25M $	16.74M $	0.02%	+4.54%	-18.35%
387		ARPA Chain	ARPA	0.03394	42.14M $	10.64M $	0.02%	+2.35%	-13.30%
388		dKargo	DKA	0.0412977	42.03M $	1.08M $	0%	+1.37%	-10.91%
389		Mango	MNGO	0.0416417	41.64M $	359.22K $	0%	+1.22%	-5.22%
390		TomoChain	TOMO	0.44311	41.11M $	3.71M $	0.01%	+6.47%	-16.75%
391		HUNT	HUNT	0.371185	40.96M $	1.64M $	0%	+2.78%	-13.28%
392		Band Protocol	BAND	1.163	40.90M $	6.61M $	0.01%	+3.47%	-14.19%
393		Enzyme	MLN	20.0624	40.90M $	7.52M $	0.01%	-2.11%	-17.79%
394		Ribbon Finance	RBN	0.2523	40.81M $	2.71M $	0%	+15.52%	+1.98%
395		Cocos-BCX	COCOS	0.6133	40.70M $	1.39M $	0%	+2.83%	-10.61%
396		mStable USD	MUSD	0.984948	40.47M $	13.61K $	0%	-1.77%	-1.23%
397		Alpine F1 Team Fan Token	ALPINE	3.5461	40.21M $	7.90M $	0.01%	+1.85%	-21.07%
398		Rari Governance Token	RGT	14.44	39.94M $	90.74K $	0%	0%	-21.11%
399		Astrafer	ASTRAFER	2.84079	39.92M $	87.98K $	0%	+0.19%	-23.69%
400		Travala.com	AVA	0.760342	39.27M $	1.85M $	0%	+4.87%	-12.43%


*/

